package com.geekymon2.carmarketplace.core.autoconfiguration.security.jwt;

import com.geekymon2.carmarketplace.core.exception.jwt.JwtTokenIncorrectStructureException;
import com.geekymon2.carmarketplace.core.exception.jwt.JwtTokenMalformedException;
import com.geekymon2.carmarketplace.core.exception.jwt.JwtTokenMissingException;
import com.geekymon2.carmarketplace.core.autoconfiguration.security.properties.JwtConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JwtTokenUtilTest {

    @Mock
    JwtConfig config;
    private JwtTokenUtil tokenUtil;

    @BeforeEach
    public void setup(){
        tokenUtil = new JwtTokenUtil(config);
    }

    @Test
    @DisplayName("Generate a valid JWT authentication token test.")
    void generateToken_ValidConfig() {
        Mockito.when(config.getJwtSecret()).thenReturn("testing");
        Mockito.when(config.getJwtValidity()).thenReturn((long)20);

        String token = tokenUtil.generateToken("test");
        Assertions.assertNotNull(token);
        Assertions.assertTrue(token.length() > 0);
    }

    @Test
    @DisplayName("Validate a malformed token test.")
    void validateToken_Malformed() {
        Mockito.when(config.getJwtSecret()).thenReturn("testing");

        Assertions.assertThrows(JwtTokenMalformedException.class,
                () -> tokenUtil.validateToken("Bearer qwerty"),
                "JwtTokenMalformedException was expected");
    }

    @Test
    @DisplayName("Validate incorrect structure token test.")
    void validateToken_IncorrectStructure() {
        Assertions.assertThrows(JwtTokenIncorrectStructureException.class,
                () -> tokenUtil.validateToken("foo"),
                "JwtTokenIncorrectStructureException was expected");
    }

    @Test
    @DisplayName("Validate missing token test.")
    void validateToken_TokenMissing() {
        Assertions.assertThrows(JwtTokenMissingException.class,
                () -> tokenUtil.validateToken("Bearer foo"),
                "JwtTokenMissingException was expected");
    }
}