package com.novacloud.data.formula;

import java.util.Locale;
import java.util.Map;
/**
 * 做2值之间的计算。
 * 三元运算符，需要转化为二元表示
 * 值类型运算符，创建或者从vs中获取值
 * @author jindw
 */
public interface OperationStrategy {

	/**
	 * @param vs 运算变量表
	 * @return 运算结果
	 * @see com.novacloud.data.formula.impl.OperationStrategyImpl#evaluate
	 */
	 Object evaluate(ExpressionToken token,Map<String,Object> vs) ;
	 Object getVar(Map<String, Object> vs,Object key);
	 Map<String, Function> getGlobalFnMap();
	 Map<String, Function> getGlobalFnMap(Locale locale);
}
