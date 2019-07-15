/*
 * Copyright 2016 Phaneesh Nagaraja <phaneesh.n@gmail.com>.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package io.dropwizard.revolver.core.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.dropwizard.revolver.core.config.resilience.ResilienceCommandConfig;
import io.dropwizard.revolver.core.config.sentinel.SentinelCommandConfig;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author phaneesh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@ToString
public class RevolverServiceConfig {

    protected ThreadPoolGroupConfig threadPoolGroupConfig;
    @NotNull
    @NotBlank
    private String type;
    @NotNull
    @NotBlank
    private String service;
    private String fallbackAddress;
    private HystrixCommandConfig runtime = new HystrixCommandConfig();
    private SentinelCommandConfig sentinelCommandConfig = new SentinelCommandConfig();
    private ResilienceCommandConfig resilienceCommandConfig = new ResilienceCommandConfig();

    public RevolverServiceConfig(String type, String service, SentinelCommandConfig sentinelCommandConfig) {
        this.type = type;
        this.service = service;
        this.sentinelCommandConfig = sentinelCommandConfig;
    }
}
