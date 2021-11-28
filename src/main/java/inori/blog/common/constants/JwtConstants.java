package inori.blog.common.constants;

/**
 * jwt相关配置
 *
 * @author Inori
 */
public interface JwtConstants {

    String AUTH_HEADER = "Authorization";

    String BEARER = "Bearer ";

    String SECRET = "defaultSecret";

    Long EXPIRATION = 604800L;

}
