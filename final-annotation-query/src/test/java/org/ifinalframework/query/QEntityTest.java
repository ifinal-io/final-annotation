package org.ifinalframework.query;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * QEntityTest.
 *
 * @author ilikly
 * @version 1.3.1
 * @since 1.3.1
 */
@ExtendWith({MockitoExtension.class})
class QEntityTest {

    @Spy
    private QEntity entity;

    @Mock
    private QProperty property;

    @Test
    void getName() {
        when(entity.getType()).thenReturn(QEntity.class);
        assertEquals(QEntity.class.getName(),entity.getName());
        assertEquals(QEntity.class.getSimpleName(),entity.getSimpleName());

        when(entity.getVersionProperty()).thenReturn(null);
        assertFalse(entity.hasVersionProperty());

        when(entity.getProperty(anyString())).thenReturn(null);
        assertThrows(IllegalStateException.class,() -> entity.getRequiredProperty("path"));


        when(entity.getProperty(anyString())).thenReturn(property);
        assertEquals(property,entity.getRequiredProperty("path"));


    }

}