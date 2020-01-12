package jp.mycomp.zzz.common.mbg.plugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * モデルに基底クラスを追加するプラグイン
 * <p />
 * mybatis-generatorの既定の動作では基底クラスはPrimaryKeyになります。<br />
 * 本プラグインとの干渉を避けるためモードタイプはflatを前提とします。<br />
 * (generatorConfig.xmlのTable要素のmodeTypeがflatを前提とする。)
 * 
 * @author nextdoorwith
 *
 */
public class AddBaseEntityPlugin extends BasePluginAdapter {

	/** プロパティ名: 基底クラス(完全修飾クラス名を想定) */
	protected static final String PROP_BASE_CLASS = "baseClass";

	/** プロパティ名: 除外プロパティ */
	protected static final String PROP_EX_PROPS = "excludeProperties";

	/** 完全修飾クラスタイプ */
	protected FullyQualifiedJavaType superClassFqjt;

	/** 除外プロパティマップ */
	protected Map<String, Object> excludePropMap;

	/** コンストラクタ */
	public AddBaseEntityPlugin()
	{
		super();
		this.excludePropMap = new HashMap<>();
	}

	@Override
	public void setProperties(Properties properties) {

		String clazz = properties.getProperty(PROP_BASE_CLASS);
		if (StringUtils.isNotEmpty(clazz)) {
			this.superClassFqjt = new FullyQualifiedJavaType(clazz);
		}

		String propstr = properties.getProperty(PROP_EX_PROPS);
		if (propstr != null) {
			String[] props = propstr.split(",");
			for (String p : props) {
				this.excludePropMap.put(p.trim().toLowerCase(), null /* dummy */);
			}
		}
	}

	@Override
	public boolean validate(List<String> warnings) {
		return this.superClassFqjt != null;
	}

	@Override
	public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
			IntrospectedTable introspectedTable, ModelClassType modelClassType)
	{
		// 基底クラスに含まれるフィールドを除外
		String name = field.getName();
		if (isTargetField(name)) {
			logger.debug(myName + ": excluded field: {}", name);
			return false;
		}
		return true;
	}

	@Override
	public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType)
	{
		// 基底クラスに含まれるgetterを除外
		String fieldName = method.getName().substring("get".length());
		if (isTargetField(fieldName)) {
			logger.debug(myName + ": excluded getter: {}", fieldName);
			return false;
		}
		return true;
	}

	@Override
	public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType)
	{
		// 基底クラスに含まれるsetterを除外
		String fieldName = method.getName().substring("set".length());
		if (isTargetField(fieldName)) {
			logger.debug(myName + ": excluded setter: {}", fieldName);
			return false;
		}
		return true;
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

		// 基底クラスの書き換え
		Optional<FullyQualifiedJavaType> sc = topLevelClass.getSuperClass();
		if (sc.isPresent()) {
			logger.warn(myName + ": super class is already defined: {}", sc.get());
			return false;
		}

		// import/extends句に宣言を追加
		topLevelClass.addImportedType(this.superClassFqjt);
		topLevelClass.setSuperClass(this.superClassFqjt.getShortName());

		return true;
	}

	/**
	 * 対象フィールドかを判定する。
	 * 
	 * @param name フィールド名称
	 * @return 対象フィールドの場合はtrue、それ以外はfalse
	 */
	protected boolean isTargetField(String name) {
		return this.excludePropMap.containsKey(name.toLowerCase());
	}

}
