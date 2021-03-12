package com.koala.myboot.config;

import ch.qos.logback.core.filter.EvaluatorFilter;
import com.koala.myboot.model.Car;
import com.koala.myboot.model.Pet;
import com.koala.myboot.model.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 *  @Configuration告诉SpringBoot这是一个配置类 == 配置文件
 *  1.配置类中使用@Bean标注在方法上个容器注册组件,默认也是单实例
 *  2.配置类本身也是组件
 *  3.proxyBeanMethods:代理bean方法
 *    Full(proxyBeanMethods = true)全量配置,【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *    Lite(proxyBeanMethods = false)轻量配置【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *    组件依赖必须使用Full模式默认。其他默认是否Lite模式
 *   4.给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 */

@Import({User.class, EvaluatorFilter.class})
@Configuration(proxyBeanMethods = false)//告诉springboot这是一个配置类 == 配置文件
//@ConditionalOnBean(name="tom")//放在类上说明当容器中有tom组件时,下面的组件才生效
@ConditionalOnMissingBean(name="tom")//放在类上说明当容器中有tom组件时,下面的组件才生效
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    /*
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     **/
    //@ConditionalOnBean在方法里时,当容器中有tom组件时并且tom组件在该组件前面,下面的组件才生效.
    //在spring ioc的过程中，优先解析@Component，@Service，@Controller注解的类。其次解析配置类，也就是@Configuration标注的类。最后开始解析配置类中定义的bean。
    //示例代码中bean1是定义在配置类中的，当执行到配置类解析的时候，@Component，@Service，@Controller ,@Configuration标注的类已经全部扫描，所以这些BeanDifinition已经被同步。
    //但是bean1的条件注解依赖的是bean2，bean2是被定义的配置类中的，所以此时配置类的解析无法保证先后顺序，就会出现不生效的情况。
    //总结:在配置类中定义Bean，如果使用@ConditionalOnBean注解依赖的Bean是通过配置类触发解析的，则执行结果依赖配置类加载顺序
    //所以tom在user01组件下面的话则该注解不生效
//    @ConditionalOnBean(name="tom")
    @Bean//给容器中添加组件,以方法名作为组件ID,返回类型就是组件类型,方法返回的值就是组件在容器中的实例
    public User user01(){
        User user = new User("zhangsan", 18);
        user.setPet(pet01());
        return user;

    }

    @Bean("tom22")//给容器中添加组件,以方法名作为组件ID,返回类型就是组件类型,方法返回的值就是组件在容器中的实例
    public Pet pet01(){
        return new Pet("mouse");

    }
}
