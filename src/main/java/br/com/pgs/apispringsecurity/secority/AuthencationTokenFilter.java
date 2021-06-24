package br.com.pgs.apispringsecurity.secority;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.intercept.RunAsUserToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.pgs.apispringsecurity.util.Util;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class AuthencationTokenFilter extends OncePerRequestFilter{
	 @Value("${security.token}")
	    private String token;

	    @SneakyThrows
	    @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException,
	            IOException {

	        String autorization = request.getHeader(HttpHeaders.AUTHORIZATION);
	        try {
				if(Util.criaTokenCriptorgrafado(token).equals(autorization)){
				    RunAsUserToken userToken =
				            new RunAsUserToken(token, null,null,null,null);
				    userToken.setAuthenticated(true);
				    SecurityContextHolder.getContext().setAuthentication(userToken);
				}
			} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | IllegalBlockSizeException
					| BadPaddingException e) {
				
				e.printStackTrace();
			}
	        chain.doFilter(request, response);
	    }
	

}
