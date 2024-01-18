package com.jh.leetcode.dym;

import java.util.*;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WordBreak {
    // 定义状态 dp[i] 为字符串charAt(i)时的true or false
    // 定义状态转移方程 dp[i]= dp[i-word[wordDict[j]]] || dp[i-word[wordDict[j-1]]] || dp[i-word[wordDict[0]]]
    // 定义边界值 dp[0]为true

    public  boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer,Boolean> flagMap=new HashMap<>();
        return wordDict(s,wordDict,flagMap);
    }

    public  boolean wordDict(String s, List<String> wordDict,Map<Integer,Boolean> flagMap) {
        if (s.length() == 0) return true;
        if (flagMap.containsKey(s.length()))return flagMap.get(s.length());
        Boolean flag = false;
        for (int i = 0; i < wordDict.size(); i++) {
            if (s.endsWith(wordDict.get(i))) {
                flag = flag || wordBreak(s.substring(0,s.length() - wordDict.get(i).length()), wordDict);
            }
        }
        flagMap.put(s.length(),flag);
        return flag;
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
