package wing.support.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import wing.support.service.SupportService;
import wing.support.web.dto.SupportResponseDto;
import wing.support.web.dto.SupportSaveDto;

import java.util.List;

@Api(tags = {"Support Controller"})
@RestController
@AllArgsConstructor
@CrossOrigin
public class SupportController {

    private final SupportService supportService;

    @ApiOperation(value = "전체 후원 정보 조회")
    @GetMapping("/api/support/")
    private List<SupportResponseDto> getSupportList() {
        return supportService.findAll();
    }

    @ApiOperation(value = "후원 정보를 아티스트 ID로 조회", notes = "아티스트 ID 필요, 해당 아티스트를 후원한 모든 내역을 가져옴")
    @GetMapping("/api/support/artist/{id}")
    private List<SupportResponseDto> getSupportListByArtistId(@PathVariable("id") String id) {
        return supportService.findByArtistId(id);
    }

    @ApiOperation(value = "후원 정보를 유저 ID로 조회", notes = "유저 ID 필요, 해당 유저가 후원한 모든 내역을 가져옴")
    @GetMapping("/api/support/user/{id}")
    private List<SupportResponseDto> getSupportListByUserId(@PathVariable("id") String id) {
        return supportService.findByUserId(id);
    }

    @ApiOperation(value = "후원 정보 저장")
    @PostMapping("/api/support/")
    private ObjectId save(@RequestBody SupportSaveDto requestDto) {
        return supportService.save(requestDto);
    }

    @ApiOperation(value = "후원 정보를 UID로 조회", notes = "UID 필요")
    @GetMapping("/api/support/uid/{uid}")
    private SupportResponseDto getSupportByUid(@PathVariable("uid") String uid) {
        return supportService.findByUid(uid);
    }

    @ApiOperation(value = "후원 정보 삭제", notes = "UID 필요, 해당 후원 내역을 삭제")
    @DeleteMapping("/api/support/uid/{uid}")
    private String deleteByUid(@PathVariable("uid") String uid) {
        return supportService.deleteByUid(uid);
    }
}
