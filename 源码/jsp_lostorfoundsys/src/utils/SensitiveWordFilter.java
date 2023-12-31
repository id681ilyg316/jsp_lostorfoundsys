package utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class SensitiveWordFilter {
	@SuppressWarnings("rawtypes")
	public Map sensitiveWordMap = null;
	public static int minMatchTYpe = 1;      //最小匹配规则
	public static int maxMatchType = 2;      //最大匹配规则
	
	/**
	 * 构造函数，初始化敏感词库
	 */
	public SensitiveWordFilter(String filePath){
		sensitiveWordMap = new SensitiveWordInit().initKeyWord(filePath);
	}
	
	//判断文字是否包含敏感字符
	public boolean isContaintSensitiveWord(String txt,int matchType){
		boolean flag = false;
		for(int i = 0 ; i < txt.length() ; i++){
			int matchFlag = this.CheckSensitiveWord(txt, i, matchType); //判断是否包含敏感字符
			if(matchFlag > 0){    //大于0存在，返回true
				flag = true;
			}
		}
		return flag;
	}
	
	// 获取文字中的敏感词
	public Set<String> getSensitiveWord(String txt , int matchType){
		Set<String> sensitiveWordList = new HashSet<String>();
		/*去除全部空格*/
		//txt = txt.replaceAll(" ","");
		for(int i = 0 ; i < txt.length() ; i++){
			int length = CheckSensitiveWord(txt, i, matchType);    //判断是否包含敏感字符
			if(length > 0){    //存在,加入list中
				sensitiveWordList.add(txt.substring(i, i+length));
				i = i + length - 1;    //减1的原因，是因为for会自增
			}
		}
		
		return sensitiveWordList;
	}
	
	//替换敏感字字符
	public String  replaceSensitiveWord(String txt,int matchType,String replaceChar){
		String resultTxt = txt;
		Set<String> set = getSensitiveWord(txt, matchType);     //获取所有的敏感词
		Iterator<String> iterator = set.iterator();
		String word = null;
		String replaceString = null;
		while (iterator.hasNext()) {
			word = iterator.next();
			replaceString = getReplaceChars(replaceChar, word.length());
			resultTxt = resultTxt.replaceAll(word, replaceString);
		}
		
		return resultTxt;
	}
	
	// 获取替换字符串
	
	private String getReplaceChars(String replaceChar,int length){
		String resultReplace = replaceChar;
		for(int i = 1 ; i < length ; i++){
			resultReplace += replaceChar;
		}
		
		return resultReplace;
	}
	
	//检查文字中是否包含敏感字符
	
	@SuppressWarnings({ "rawtypes"})
	public int CheckSensitiveWord(String txt,int beginIndex,int matchType){
		boolean  flag = false;    //敏感词结束标识位：用于敏感词只有1位的情况
		int matchFlag = 0;     //匹配标识数默认为0
		char word = 0;
		/*标识，这是这次关键词判断的第几次*/
		int spaceCount = 0;
		Map nowMap = sensitiveWordMap;
		for(int i = beginIndex; i < txt.length() ; i++ , spaceCount++ ){
			word = txt.charAt(i);
			/*判断空格,并且不是第一个敏感词的开始词*/
			if (spaceCount != 0 && Character.isSpaceChar(word)) {
				matchFlag++;
				continue;
			}
			nowMap = (Map) nowMap.get(word);     //获取指定key
			if(nowMap != null){     //存在，则判断是否为最后一个
				matchFlag++;     //找到相应key，匹配标识+1 
				if("1".equals(nowMap.get("isEnd"))){       //如果为最后一个匹配规则,结束循环，返回匹配标识数
					flag = true;       //结束标志位为true   
					if(SensitiveWordFilter.minMatchTYpe == matchType){    //最小规则，直接返回,最大规则还需继续查找
						break;
					}
				}
			}
			else{     //不存在，直接返回
				break;
			}
		}
		if(matchFlag < 2 || !flag){        //长度必须大于等于1，为词 
			matchFlag = 0;
		}
		return matchFlag;
	}
	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();
		String filePath = "./src/servlet/sensitiveWords.txt";
		SensitiveWordFilter filter = new SensitiveWordFilter(filePath);
		System.out.println("敏感词的数量：" + filter.sensitiveWordMap.size());
		String txt = "太多的干 逼伤感情怀也许只局限于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释自杀指南怀那些自己经历的伤感。 一元 硬币  游戏机上分 "
						+ " 1234然3456后  我 是 你 妈 妈法ertubredxcong.com轮功，平安夜自杀 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，"
						+ "做爱，难过就日你妈 夜 总   会躺在某一我是你爸爸个人的怀里尽情的阐述心扉或者手机卡复制器一个人一杯红酒一部电影在夜三级片 深人静的晚上，关上电话静静的发呆着。一元硬币";
		System.out.println("待检测语句字数：" + txt.length());

		Set<String> set = filter.getSensitiveWord(txt, 1);
		long endTime = System.currentTimeMillis();
//		System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
		System.out.println("总共消耗时间为：" + (endTime - beginTime));
		System.out.println("替换关敏感词");
		System.out.println(filter.replaceSensitiveWord(txt,2,"*"));
	}
}
