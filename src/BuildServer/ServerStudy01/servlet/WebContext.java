package BuildServer.ServerStudy01.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * xml解析流程为：
 * servlet-mapping -> url-pattern -> servlet-name ->
 * servlet -> servlet-name -> servlet-class
 *
 * 因此需要将解析出的list进一步更改为map
 */
public class WebContext {
    private List<Entity> entityList ;
    private List<Mapping> mappingList ;

    //key -> servlet-name , value -> servlet-class
    private Map<String,String> entityMap = new HashMap<>();
    //key -> url-pattern , value -> servlet-name
    private Map<String,String> mappingMap = new HashMap<>();

    public WebContext(List<Entity> entityList, List<Mapping> mappingList) {
        this.entityList = entityList;
        this.mappingList = mappingList;
        init();
    }

    private void init(){
        for(Entity entity : entityList){
            //将servlet中的name和class对应起来
            entityMap.put(entity.getName(),entity.getClz());
        }

        for(Mapping mapping : mappingList){
            //将mapping中的URL和name对应起来
            for(String url : mapping.getPatterns()){
                mappingMap.put(url,mapping.getName());
            }
        }
    }

    public String getClz(String url){
        String name = mappingMap.get(url);
        String clz = entityMap.get(name);
        return clz;
    }

}
