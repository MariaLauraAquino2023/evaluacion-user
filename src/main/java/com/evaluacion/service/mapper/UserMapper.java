package com.evaluacion.service.mapper;

import com.evaluacion.dto.request.CreateUserRequest;
import com.evaluacion.dto.response.CreateUserResponse;
import com.evaluacion.model.User;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN,
		collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
		uses = UserPhoneMapper.class)
public interface UserMapper {

	@Mapping(source="lastLogin",target = "last_login")
	@Mapping(source="isActive",target = "isactive")
	@Mapping(target = "mensaje",ignore = true)
	CreateUserResponse createUserResponseFromUser(User user);
	@Mapping(target = "id",ignore = true)
	@Mapping(target = "created",ignore = true)
	@Mapping(target = "modified",ignore = true)
	@Mapping(target = "lastLogin",ignore = true)
	@Mapping(target = "token",ignore = true)
	@Mapping(target = "isActive",ignore = true)
	User userFromCreateUserRequest(CreateUserRequest req);

}
