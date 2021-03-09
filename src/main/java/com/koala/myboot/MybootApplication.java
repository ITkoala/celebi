package com.koala.myboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//想要改变扫描路径可以使用 @SpringBootApplication(scanBasePackages = "com.koala"),这样就可以访问application上层级的包
//@SpringBootApplication == @SpringBootConfiguration + EnableAutoConfiguration + @ComponentScan("com.koala.myboot")
//不指定则主程序所在包及其下面的所有子包里面的组件都会被默认扫描进来
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.koala.myboot")
@SpringBootApplication
public class MybootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MybootApplication.class, args);
//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//        Pet pet01 = run.getBean("pet01", Pet.class);
//        Pet pet02 = run.getBean("pet01", Pet.class);
//        System.out.println(pet01 == pet02 );
//
//        //4.com.koala.myboot.config.MyConfig$$EnhancerBySpringCGLIB$$c1471b66@2b9f74d0
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
//        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法,springboot总会检查这个组价是否在容器中有,有则保持组件单实例
//        //如果@Configuration(proxyBeanMethods = false)代理对象调用方法
//        User user = bean.user01();
//        User user1 = bean.user01();
//        System.out.println(user == user1);
//
//        User user01 = run.getBean("user01", User.class);
//        Pet pet = run.getBean("pet01", Pet.class);
//        System.out.println("是否同一个对象:"+(user01.getPet()==pet));
//
//
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        for (String name : beanNamesForType) {
//            System.out.println(name);
//        }
//
//        EvaluatorFilter bean1 = run.getBean(EvaluatorFilter.class);
//        System.out.println(bean1);

        System.out.println("容器中tom组件:"+run.containsBean("tom"));
        System.out.println("容器中tom22组件:"+run.containsBean("tom22"));
        System.out.println("容器中User组件:"+run.containsBean("user01"));
    }

}
