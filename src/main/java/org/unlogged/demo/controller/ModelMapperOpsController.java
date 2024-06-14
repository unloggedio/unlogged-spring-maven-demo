package org.unlogged.demo.controller;

import org.modelmapper.*;
import org.modelmapper.spi.MappingContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.models.mapper.dto.UserModelDto;
import org.unlogged.demo.models.mapper.dto.UserModelMiniDto;
import org.unlogged.demo.models.mapper.model.AddressModel;
import org.unlogged.demo.models.mapper.model.ContactInformation;
import org.unlogged.demo.models.mapper.model.UserModel;

import java.util.List;

@RestController
@RequestMapping("/modelmapper")
public class ModelMapperOpsController {

    private ModelMapper mapper = new ModelMapper();

    private UserModel getDefaultModel() {
        return new UserModel(1L, "User1",
                new AddressModel("#144", "StreetX", "AreaX", "CityX", "StateX", "CountryX", "PinX"),
                new ContactInformation(List.of("user1@gmail.com", "user1@yahoo.com"), List.of("phone-number-1", "phone-number-2")));
    }

    private UserModelDto getEmptyUserModelDto() {
        return new UserModelDto();
    }

    @RequestMapping("/userdtomini")
    public UserModelMiniDto getUserModelMiniDto() {

        UserModel userModel = new UserModel(1L, "user1", null, null);
        return mapper.map(userModel, UserModelMiniDto.class);
    }

    @RequestMapping("/userdto")
    public UserModelDto getUserModelDto() {
        ModelMapper mm = new ModelMapper();
        TypeMap<UserModel, UserModelDto> propertyMapper = mm.createTypeMap(UserModel.class, UserModelDto.class);
        propertyMapper.addMappings(
                mapper -> {
                    mapper.map(src -> src.getAddress().toString(), UserModelDto::setAddress);
                    mapper.skip(UserModelDto::setPhoneNumber);
                    mapper.skip(UserModelDto::setEmail);
                }
        );
        return mm.map(getDefaultModel(), UserModelDto.class);
    }

    @RequestMapping("/providerAndConditional")
    public UserModelDto getUserModelDtoWithProvider() {
        ModelMapper mm = new ModelMapper();
        Provider<UserModelDto> userModelProvider = p -> getEmptyUserModelDto();
        Condition<Long, Long> nullId = ctx -> ctx.getSource() != null;
        TypeMap<UserModel, UserModelDto> propertyMapper = mm.createTypeMap(UserModel.class, UserModelDto.class);
        propertyMapper.addMappings(
                mapper -> {
                    mapper.map(src -> src.getAddress().toString(), UserModelDto::setAddress);
                    mapper.when(nullId).skip(UserModel::getUsername, UserModelDto::setUsername);
                }
        );
        propertyMapper.setProvider(userModelProvider);
        return mm.map(getDefaultModel(), UserModelDto.class);
    }

    Converter<UserModel, UserModelDto> userDtoConverter = new Converter<UserModel, UserModelDto>() {
        public UserModelDto convert(MappingContext<UserModel, UserModelDto> context) {
            UserModel src = context.getSource();
            UserModelDto dest = new UserModelDto();
            dest.setAddress(src.getAddress().toString());
            dest.setEmail(src.getContactInformation().getEmails().stream().findFirst().get());
            dest.setPhoneNumber(src.getContactInformation().getNumbers().stream().findFirst().get());
            dest.setUsername(src.getUsername());
            return dest;
        }
    };

    @RequestMapping("/converter")
    public UserModelDto getFromConverter() {
        ModelMapper mm = new ModelMapper();
        mm.addConverter(userDtoConverter);
        return mm.map(getDefaultModel(), UserModelDto.class);
    }
}
