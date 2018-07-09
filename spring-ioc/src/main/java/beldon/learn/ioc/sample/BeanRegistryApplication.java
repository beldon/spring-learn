package beldon.learn.ioc.sample;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author Beldon
 * @create 2018-07-09 10:36
 */
public class BeanRegistryApplication {
    public static void main(String[] args) throws Exception{
        BeanDefinition beanDefinition = BeanDefinitionReaderUtils.createBeanDefinition(null, SimpleBean.class.getName(), BeanRegistryApplication.class.getClassLoader());
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("simpleBean", beanDefinition);
        System.out.println(beanFactory.containsBean("simpleBean"));
        SimpleBean bean = beanFactory.getBean(SimpleBean.class);
        System.out.println(bean);
    }
}
