package jp.mycomp.zzz.common.mbg.plugin;

import org.mybatis.generator.api.PluginAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * mybatis-generatorプラグイン用基底クラス
 * 
 * @author nextdoorwith
 *
 */
public abstract class BasePluginAdapter extends PluginAdapter {

	/** プラグイン名 */
	protected String myName;

	/** ロガー */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/** コンストラクタ */
	public BasePluginAdapter()
	{
		this.myName = getClass().getSimpleName();
	}

}
