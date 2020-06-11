package wing.support.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wing.support.domain.Support;

@NoArgsConstructor
@Getter
public class SupportSaveDto {

    private String userId;
    private String artistId;
    private Long amount;
    private String datetime;
    private String uid;

    @Builder
    public SupportSaveDto(String userId, String artistId, Long amount, String datetime, String uid) {
        this.userId = userId;
        this.artistId = artistId;
        this.amount = amount;
        this.datetime = datetime;
        this.uid = uid;
    }

    public Support toEntity() {
        return Support.builder()
                .userId(userId)
                .artistId(artistId)
                .amount(amount)
                .datetime(datetime)
                .uid(uid)
                .build();
    }
}
