/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logparser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Guanhoe
 */
public class LogParser {

    /**
     * @param args the command line arguments
     */
    
    public ArrayList<String> ipAddress, URL, duration;
    
    /** 
    * Class constructor.
    */
    public LogParser(){
        ipAddress = new ArrayList();
        URL = new ArrayList();
    }
    
    public void readFile(String filepath) throws FileNotFoundException, IOException{
        String regex = "^([\\d.]+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\d+) \"([^\"]+)\" \"(.+?)\"";
        try (FileInputStream fstream = new FileInputStream(filepath)){
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
//                System.out.println (strLine);
                Pattern p = Pattern.compile(regex);
                Matcher matcher = p.matcher(strLine);
                if (!matcher.matches()) {
//                    System.err.println("Bad log entry: " + strLine);
                } else {
                    ipAddress.add(matcher.group(1));
                    String url = matcher.group(5).replaceAll("GET", "").replaceAll("HTTP/1.1", "").trim();
                    URL.add(url);
                }
            }
        }
    }
    
    public HashMap<String,Integer> countIPVisits(){
        HashMap<String,Integer> map = new HashMap<>();
        for (String ip : ipAddress) {
//            System.out.println(ip);
            if (!map.containsKey(ip)){
                map.put(ip, 1);
            } else {
                map.put(ip, map.get(ip)+1);
            }
        }
        return map;
    }
    
    public HashMap<String,Integer> countURLVisits(){
        HashMap<String,Integer> map = new HashMap<>();
        for (String url : URL) {
//            System.out.println(url);
            if (!map.containsKey(url)){
                map.put(url, 1);
            } else {
                map.put(url, map.get(url)+1);
            }
        }
        return map;
    }
    
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer> > list = new LinkedList< >(map.entrySet());
 
        //sort descending order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
        //assign new 
        HashMap<String, Integer> temp = new LinkedHashMap<>(3);
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    
    public static List<String> getTop3(HashMap<String, Integer> map) {
        List<Entry<String, Integer> > list = new LinkedList<>(map.entrySet());
        List<String> temp = new ArrayList<>(3);
        for(Entry<String, Integer> e : list) {
            temp.add(e.getKey());
            if(temp.size() == 3) {
                break;
            }
        }
        return temp;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        LogParser parser = new LogParser();
        parser.readFile("log_file.log");
        
        HashMap<String,Integer> IPvisits = parser.countIPVisits();
//        System.out.println(IPvisits);
        System.out.println("The number of unique IP addresses: " + IPvisits.size());
        
        HashMap<String,Integer> URLvisits = parser.countURLVisits();
//        System.out.println(URLvisits);
        HashMap<String, Integer> sortedURLvisits = sortByValue(URLvisits);
//        System.out.println(sortedURLvisits);
        List<String> top3URL = getTop3(sortedURLvisits);
        System.out.println("The top 3 most visited URLs: " + top3URL);
        
        HashMap<String, Integer> sortedIPvisits = sortByValue(IPvisits);
//        System.out.println(sortedIPvisits);
        List<String> top3IP = getTop3(sortedIPvisits);
        System.out.println("The top 3 most active IP addresses: " + top3IP);
    }
}
