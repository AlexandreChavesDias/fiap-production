package br.com.fiap.apiproduction;
import br.com.fiap.apiproduction.core.Production;
import br.com.fiap.apiproduction.core.usecase.impl.ProductionUseCaseImpl;
import br.com.fiap.apiproduction.dataprovider.repository.impl.ProductionRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductionUseCaseImplTest {
    @Mock
    private ProductionRepositoryImpl productionUseCase;
    private Production productionMock;

    List<UUID> productId;

    @BeforeEach
    void setUp() {
        productionMock = mock(Production.class);
        productId = Arrays.asList(
                UUID.randomUUID(),
                UUID.randomUUID()
        );
    }

    @Test
    void testGetProductionById() {

    }
}