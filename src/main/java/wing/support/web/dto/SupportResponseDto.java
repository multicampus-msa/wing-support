package wing.support.web.dto;

import lombok.Getter;
import wing.support.domain.Support;

@Getter
public class SupportResponseDto {

    private final String artistName;
    private final String userName;
    private final Long amount;
    private final String datetime;

    public SupportResponseDto(Support support) {
        this.artistName = support.getArtistName();
        this.userName = support.getUserName();
        this.amount = support.getAmount();
        this.datetime = support.getDatetime();
    }
}
