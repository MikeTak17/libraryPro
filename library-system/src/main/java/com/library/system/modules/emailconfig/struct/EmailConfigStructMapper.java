package com.library.system.modules.emailconfig.struct;

import com.library.system.modules.emailconfig.bo.EmailConfigInsert;
import com.library.system.modules.emailconfig.bo.EmailConfigUpdate;
import com.library.system.modules.emailconfig.entity.EmailConfig;
import com.library.system.modules.emailconfig.vo.EmailConfigVO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * 郵件配置(EmailConfig)对象映射转换
 *
 * @author makejava
 * @since 2026-02-26
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmailConfigStructMapper {

    EmailConfig updateToEmailConfig(EmailConfigUpdate update);

    EmailConfig insertToEmailConfig(EmailConfigInsert insert);

    EmailConfigVO emailConfigToEmailConfigVO(EmailConfig emailConfig);

    List<EmailConfigVO> configListToEmailConfigVO(List<EmailConfig> configList);

}

