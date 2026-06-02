
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * Verificar que el entorno de testing funciona.
 * 
 * Solo verifica que:
 *   1. JUnit 5 está correctamente configurado.
 *   2. Maven Surefire lo detecta y lo ejecuta.
 *   3. Las assertions funcionan.
 * 
 * Se eliminará cuando tengamos tests reales en la Fase 1
 */
public class SmokeTest {
    
    @Test
    @DisplayName("JUnit 5 está configurado correctamente")
    void junitFunciona(){
        assertTrue(true, "Si esto falla, JUnit no está configurado");
    }
    
    @Test
    @DisplayName("Java 21 está activo")
    void javaVersion(){
        String version = System.getProperty("java.version");
        assertTrue(version.startsWith("21"), "Se esperaba Java 21 pero se encontró" + version);
        
    }
}
