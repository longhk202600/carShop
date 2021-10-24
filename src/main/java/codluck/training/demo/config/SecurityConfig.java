/*
 *  SecurityConfig.java
 *
 *  Copyright (c) 2020 JSC
 */
package codluck.training.demo.config;

import codluck.training.demo.define.DefineConstrant;
import codluck.training.demo.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security Config
 *
 * @author sshimu
 * @version 1 2020/12/01
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers(DefineConstrant.HOME_PARTNER_MAPPING,
                        DefineConstrant.EDIT_SHOWROOM,
                        DefineConstrant.SAVE,
                        DefineConstrant.POST_CAR_PARTNER,
                        DefineConstrant.SAVE_CAR,
                        DefineConstrant.EDIT_CAR_PARTNER,
                        DefineConstrant.DELETE_CAR_PARTNER,
                        DefineConstrant.DELETE_ORDER,
                        DefineConstrant.GET_CAR_WITH_PAGE_HTML,
                        DefineConstrant.GET_ORDER_WITH_PAGE_HTML,
                        DefineConstrant.EDIT_SHOWROOM,
                        DefineConstrant.SAVE_SHOWROOM_HTML,
                        DefineConstrant.GET_POST_ORDER_WITH_PAGE,
                        DefineConstrant.LIST_ODER_MAPPING,
                        DefineConstrant.CONFIRM_ODER_MAPPING,
                        DefineConstrant.POST_CAR_MAPPING,
                        DefineConstrant.LIST_POST_ORDER)
                .access(DefineConstrant.HAS_ANY_ROLE);
        // Trang chỉ dành cho ADMIN mới vào được
        http.authorizeRequests().antMatchers(DefineConstrant.ADMIN_MAPPING,
                DefineConstrant.DELETE_MAPPING,
                DefineConstrant.ADMIN_SHOWROOM_MAPPING,
                DefineConstrant.DELETE_SHOWROOM_MAPPING,
                DefineConstrant.DELETE_ORDER_MAPPING,
                DefineConstrant.ADMIN_POST_ORDER_MAPPING,
                DefineConstrant.ADMIN_ORDER_MAPPING,
                DefineConstrant.INCOMEWEB_MAPPING).access(   DefineConstrant.HAS_ROLE_ADMIN);
        http.authorizeRequests().antMatchers(DefineConstrant.ADD_CART_MAPPING,
                        DefineConstrant.CAR_DELETE_ORDER_MAPPING,
                        DefineConstrant.POST_ORDER_MAPPING).
                access(   DefineConstrant.HAS_ANY_CUSTOMER);
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage(DefineConstrant.ERROR_MAPPING);
        http.authorizeRequests()
                // quyền cho các file css js image ở trang login logout và trang chủ
                .antMatchers(
                        DefineConstrant.FOLDER_TRAINING,
                        DefineConstrant.FOLDER_CSS,
                        DefineConstrant.FOLDER_JS,
                        DefineConstrant.FOLDER_IMAGE,
                        DefineConstrant.FOLDER_MODEL,
                        DefineConstrant.HOME_PAGE_MAPPING,
                        DefineConstrant.NEW_CAR_MAPPING,
                        DefineConstrant.GET_COMPANY_MAPPING,
                        DefineConstrant.OLD_CAR_MAPPING,
                        DefineConstrant.SEARCH_MAPPING,
                        DefineConstrant.SORT_MAPPING,
                        DefineConstrant.DETAIL_CAR_MAPPING,
                        DefineConstrant.PAGE_MAPPING,
                        DefineConstrant.REGISTER_MAPPING,
                        DefineConstrant.POST_ORDER_SAVE_MAPPING,
                        DefineConstrant.PROFILE_MAPPING,
                        DefineConstrant.EDIT_MAPPING,
                        DefineConstrant.CAR_ODER_MAPPING,
                        DefineConstrant.LIST_ODER_MAPPING,
                        DefineConstrant.CONFIRM_ODER_MAPPING,
                        DefineConstrant.SHOW_ROOM_MAPPING,
                        DefineConstrant.FORGOT_PASSWORD,
                        DefineConstrant.CHANGE_PASSWORD_MAPPING,
                        DefineConstrant.GET_SHOWROOM_MAPPING,
                        DefineConstrant.LIST_COMPANY_MAPPING,
                        DefineConstrant.ACTIVE_ACOUNT_MAPPING).permitAll()
                //mọi yêu cầu thì bắt đăng nhập
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(DefineConstrant.LOGIN_MAPPING)
                .loginPage(DefineConstrant.LOGIN_MAPPING)
                .usernameParameter(DefineConstrant.USERNAME)
                .passwordParameter(DefineConstrant.PASSWORD)
                .permitAll()
                .defaultSuccessUrl(DefineConstrant.HOME_PAGE_MAPPING)
                .failureUrl(DefineConstrant.LOGIN_MAPPING_FALSE)
                .loginProcessingUrl(DefineConstrant.J_SPRING_SECURITY_CHECK)
                .and().logout()
                .logoutUrl(DefineConstrant.LOGOUT_MAPPING).logoutSuccessUrl(DefineConstrant.LOGIN_MAPPING);
    }

    // mã hóa mật khẩu
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService) // Cung cáp userservice cho spring security
                .passwordEncoder(passwordEncoder()); // cung cấp password encoder
    }
}