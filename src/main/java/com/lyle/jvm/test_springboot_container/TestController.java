package com.lyle.jvm.test_springboot_container;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * @author Lyle
 * @version v1.0
 * @since 1.8  
 */
//@Controller
public class TestController implements ApplicationContextAware {

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println(applicationContext.getApplicationName());
    System.out.println(applicationContext.getAutowireCapableBeanFactory());
    System.out.println(applicationContext.getDisplayName());
    System.out.println(applicationContext.getId());
    System.out.println(applicationContext.getParent());
    System.out.println(applicationContext.getStartupDate());
    System.out.println(applicationContext.hashCode());
    /**
     * org.springframework.beans.factory.support.DefaultListableBeanFactory@41d426b5: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.event.internalEventListenerProcessor,org.springframework.context.event.internalEventListenerFactory,jvmApplication,org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory,bizServiceImpl,testController,testService,org.springframework.boot.autoconfigure.AutoConfigurationPackages,org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration,org.springframework.boot.autoconfigure.condition.BeanTypeRegistry,propertySourcesPlaceholderConfigurer,org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$TomcatWebSocketConfiguration,websocketServletWebServerCustomizer,org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration,org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedTomcat,tomcatServletWebServerFactory,org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration,servletWebServerFactoryCustomizer,tomcatServletWebServerFactoryCustomizer,server-org.springframework.boot.autoconfigure.web.ServerProperties,org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor,org.springframework.boot.context.properties.ConfigurationBeanFactoryMetadata,webServerFactoryCustomizerBeanPostProcessor,errorPageRegistrarBeanPostProcessor,org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletConfiguration,dispatcherServlet,spring.http-org.springframework.boot.autoconfigure.http.HttpProperties,spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties,org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration,dispatcherServletRegistration,org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration,org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration,taskExecutorBuilder,applicationTaskExecutor,spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties,org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration,defaultValidator,methodValidationPostProcessor,org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration,error,beanNameViewResolver,org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration,conventionErrorViewResolver,org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration,errorAttributes,basicErrorController,errorPageCustomizer,preserveErrorControllerTargetClassPostProcessor,spring.resources-org.springframework.boot.autoconfigure.web.ResourceProperties,org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter$FaviconConfiguration,faviconHandlerMapping,faviconRequestHandler,org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration,requestMappingHandlerAdapter,requestMappingHandlerMapping,mvcConversionService,mvcValidator,mvcContentNegotiationManager,mvcPathMatcher,mvcUrlPathHelper,viewControllerHandlerMapping,beanNameHandlerMapping,resourceHandlerMapping,mvcResourceUrlProvider,defaultServletHandlerMapping,mvcUriComponentsContributor,httpRequestHandlerAdapter,simpleControllerHandlerAdapter,handlerExceptionResolver,mvcViewResolver,mvcHandlerMappingIntrospector,org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter,defaultViewResolver,viewResolver,welcomePageHandlerMapping,requestContextFilter,org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration,hiddenHttpMethodFilter,formContentFilter,org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration,mbeanExporter,objectNamingStrategy,mbeanServer,org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration,springApplicationAdminRegistrar,org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration,org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration,standardJacksonObjectMapperBuilderCustomizer,spring.jackson-org.springframework.boot.autoconfigure.jackson.JacksonProperties,org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration,jacksonObjectMapperBuilder,org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$ParameterNamesModuleConfiguration,parameterNamesModule,org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperConfiguration,jacksonObjectMapper,org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration,jsonComponentModule,org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration,stringHttpMessageConverter,org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration,mappingJackson2HttpMessageConverter,org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration,org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration,messageConverters,org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration$LoggingCodecConfiguration,loggingCodecCustomizer,org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration$JacksonCodecConfiguration,jacksonCodecCustomizer,org.springframework.boot.autoconfigure.http.codec.CodecsAutoConfiguration,org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration,spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties,org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration,taskSchedulerBuilder,spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties,org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration,restTemplateBuilder,org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration,tomcatWebServerFactoryCustomizer,org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration,org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration,characterEncodingFilter,localeCharsetMappingsCustomizer,org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration,multipartConfigElement,multipartResolver,spring.servlet.multipart-org.springframework.boot.autoconfigure.web.servlet.MultipartProperties]; root of factory hierarchy
     * org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@7b7fdc8
     * application
     * null
     * 1551765549130
     * 129498568
     */
  }
}