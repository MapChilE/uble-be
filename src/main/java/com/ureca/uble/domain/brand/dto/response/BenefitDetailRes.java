package com.ureca.uble.domain.brand.dto.response;

import com.ureca.uble.entity.Benefit;
import com.ureca.uble.entity.enums.Rank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(description="등급별 헤택 상세 정보 DTO")
public class BenefitDetailRes {

	@Schema(description = "등급", example="우수/VIP/VVIP")
	private Rank rank;

	@Schema(description = "혜택 내용", example="결제한 금액의 10% 할인")
	private String content;

	@Schema(description="이용 방법", example="바코드 제시")
	private String manual;

	@Schema(description="제공 단위", example="월 1회")
	private String provisionCount;

	public static BenefitDetailRes from(Benefit benefit) {
		String provisionCount = benefit.getPeriod().formatProvisionCount(benefit.getNumber());
		return BenefitDetailRes.builder()
			.rank(benefit.getRank())
			.content(benefit.getContent())
			.manual(benefit.getManual())
			.provisionCount(provisionCount)
			.build();
	}

}
