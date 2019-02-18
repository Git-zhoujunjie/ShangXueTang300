package BuildServer.ServerStudy03;

import java.util.HashSet;
import java.util.Set;

/**
 * 存储servlet-mapping信息
 *     <servlet-mapping>
 *         <servlet-name>login</servlet-name>
 *         <url-pattern>/login</url-pattern>
 *         <url-pattern>/g</url-pattern>
 *     </servlet-mapping>
 */
public class Mapping {
    private String name;
    private Set<String> patterns;  //用于存储多个pattern

    public Mapping() {
        this.patterns = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPatterns() {
        return patterns;
    }

    public void addPattern(String pattern){
        this.patterns.add(pattern);
    }
}
