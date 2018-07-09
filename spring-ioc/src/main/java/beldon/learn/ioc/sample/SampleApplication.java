package beldon.learn.ioc.sample;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class SampleApplication {
    public static void main(String[] args) {

        //定位
        Resource resource = new ClassPathResource("sample.xml");
        BeanDefinitionRegistry registry = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions(resource);
        BeanFactory beanFactory = (BeanFactory) registry;
        System.out.println(beanFactory.containsBean("simpleBean"));

        SimpleBean bean = beanFactory.getBean(SimpleBean.class);
        System.out.println(bean);

//        XmlBeanFactory factory = new XmlBeanFactory(resource);
//        System.out.println(factory.containsBean("simpleBean"));
//        SimpleBean bean = factory.getBean(SimpleBean.class);
//        System.out.println(bean);
    }
}
