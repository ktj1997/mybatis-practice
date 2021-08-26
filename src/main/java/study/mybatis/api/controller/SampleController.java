package study.mybatis.api.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.mybatis.api.request.SaveUserRequest;
import study.mybatis.api.response.UserDetailResponse;
import study.mybatis.domain.dto.UserDto;
import study.mybatis.service.DateUtil;
import study.mybatis.service.SampleService;


@RestController
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping
    public UserDetailResponse getUserDetail(@RequestParam Long id) throws Exception {
        return new UserDetailResponse(sampleService.findUserById(id));
    }

    @PostMapping
    public UserDetailResponse saveUser(@RequestBody SaveUserRequest req) throws Exception {
        return new UserDetailResponse(sampleService.saveUser(
                new UserDto(
                        null,
                        req.getName(),
                        DateUtil.parseStringToDate(req.getBirth())
                )
        ));
    }
}
