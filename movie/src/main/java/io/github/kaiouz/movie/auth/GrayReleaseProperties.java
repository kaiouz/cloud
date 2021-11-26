package io.github.kaiouz.movie.auth;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 灰度发布相关的配置
 */
@ConfigurationProperties(prefix = "gray-release")
public class GrayReleaseProperties {

    /**
     * 是否启动灰度发布
     */
    private boolean enabled;

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
