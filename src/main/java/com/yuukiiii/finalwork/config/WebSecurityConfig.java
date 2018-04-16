package com.yuukiiii.finalwork.config;

import com.yuukiiii.finalwork.service.CustomUserService;
import com.yuukiiii.finalwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created by Yuukiiii
 * on 2018/4/12 18:30
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html","/header.html","/navigation.html","/checkmail.html"
                ,"/footer.html","login.html","/registered.html","/utils/sendVerifyMail"
                ,"/shopping/**","/htmlmailtest"
                ,"/mailtest"
//                , "/userManage/**","/static/**","/signup.html",
//                "/ftpuploadimg","/ftptest.html","/manageCase2/**","/examManage/**","/deptManage/**",
//                "/hospitalized/**","/drugManage/**","/chargeManage/**","/assayManage/**","/123132312.html",
//                "/caseManage/**","/vaccineManage/**","/login#/**","/getItemsCount"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index.html","/header.html","/navigation.html","/footer.html","login.html"
                        ,"/css/**","/images/**","/js/**","/fonts/**").permitAll()
                //其他地址的访问均需验证权限
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login.html").
                loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password")
                .permitAll().failureUrl("/login.html").permitAll().and()
                .logout().permitAll().and().csrf().disable().exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
    }
}
