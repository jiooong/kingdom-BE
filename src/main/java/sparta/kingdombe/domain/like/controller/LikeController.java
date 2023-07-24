package sparta.kingdombe.domain.like.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparta.kingdombe.domain.like.service.LikeService;
import sparta.kingdombe.global.responseDto.ApiResponse;
import sparta.kingdombe.global.security.UserDetailsImpl;

@RestController
@RequestMapping("/api/stories")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/{storyId}/like")
    public ApiResponse<?> updateLike(@PathVariable Long storyId,
                                     @AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println("스토리 번호 -> " + storyId + "  유저번호는 --> " + userDetails.getUsername());
        return likeService.updateLike(storyId, userDetails.getUser());
    }
}
