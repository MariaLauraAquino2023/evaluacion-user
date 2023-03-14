package com.evaluacion.service.mapper;

import com.evaluacion.dto.request.CreateUserRequest;
import com.evaluacion.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
/**
 * Mapper para mapear de los dtos de Phone para requests/responses a la entity Phone
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserPhoneMapper {

	@Mapping(target = "id",ignore = true)
	@Mapping(target = "userId",ignore = true)
    Phone userPhoneFromCreateUserRequestPhone(CreateUserRequest.Phone phone);
}
