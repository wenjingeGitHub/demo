package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class DemoApplication {
	/**
	 * 关于热部署：
	 * 1、使用springloaded进行热部署
	 * 使用的run as – java application的话，那么还需要做一些处理。
	 * 把spring-loader-1.2.4.RELEASE.jar下载下来，放到项目的lib目录中，然后把IDEA的run参数里VM参数设置为：
     * -javaagent:.\lib\springloaded-1.2.4.RELEASE.jar -noverify
     * 然后启动就可以了，这样在run as的时候，也能进行热部署
     * 但是，此种方法热部署，在添加新方法时不奏效。
     * 2、springboot + devtools（热部署）
     * 在pom.xml文件添加jar包
     * 即可发现已经可以实现热部署；
     * 不奏效的可能：
     * (1)、project>Build Automatically 必须选中；
     * (2)、超级无敌大坑：项目名字不能和官方引用的重名，会有冲突；
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
}
