package lotto.service;

import java.util.List;
import java.util.ArrayList;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;

public class LottoService {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService() {
        this.lottoNumberGenerator = new LottoNumberGenerator();
    }

    public List<Lotto> generateLottoNumbers(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(lottoNumberGenerator.generate());
        }
        return lottos;
    }
}
