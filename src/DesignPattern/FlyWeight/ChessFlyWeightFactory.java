package DesignPattern.FlyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元池，每次取对象都从池中取
 */
public class ChessFlyWeightFactory {
    //key为棋子的颜色，value为对应颜色的棋子
    private static Map<String,ChessFlyWeight> chessFlyWeightMap = new HashMap<>();

    public static ChessFlyWeight getFlyWeight(String color){
        if(chessFlyWeightMap.get(color)!=null){
            return chessFlyWeightMap.get(color);
        }else{
            ChessFlyWeight chess = new ConcreteChess(color);
            chessFlyWeightMap.put(color,chess);
            return chess;
        }
    }
}
