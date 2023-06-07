import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class BuscaBlog {

	private WebDriver driver;

	@Before
	public void setup() {
		// Configurar o WebDriver do Selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gabriella\\drivers\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless"); // Executar em modo headless (sem
		// interface gráfica)
		driver = new ChromeDriver(options);
	}

	@Dado("que estou na página inicial do blog")
	public void que_estou_na_página_inicial_do_blog() {
		// Navegar até a página inicial do blog
		driver.get("https://ww2.soc.com.br/blog/");
	}

	@Quando("eu clico em busca")
	public void eu_clico_em_busca() {
		// Localizar o elemento da caixa de busca
		WebElement botaoBusca = driver.findElement(By.cssSelector(".elementor-search-form__toggle"));
		botaoBusca.click();
	}

	@E("digito {string}")
	public void digito(String termoBusca) {
		// Digitar o termo de busca na caixa de busca
		String termoCompleto = termoBusca;
		WebElement caixaBusca = driver.findElement(By.cssSelector(".elementor-search-form__input"));
		caixaBusca.sendKeys(termoCompleto);
	}

	@E("pressiono a tecla enter")
	public void pressiono_a_tecla_enter() {
		// Localizar o elemento da caixa de busca
		WebElement caixaBusca = driver.findElement(By.cssSelector(".elementor-search-form__input"));

		// Pressionar a tecla "Enter" na caixa de busca
		caixaBusca.sendKeys(Keys.ENTER);
	}

	@Entao("vejo os resultados da pesquisa relacionados a {string}")
	public void vejo_os_resultados_da_pesquisa_relacionados_a(String termoBusca) {
		// Verificar se os resultados da pesquisa contêm o termo de busca
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement resultadoBusca = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search-results")));
		String textoResultado = resultadoBusca.getText();
		Assert.assertTrue(textoResultado.contains(termoBusca));
	}

	@After
	public void tearDown() {
		// Fechar o WebDriver do Selenium após os testes
		driver.quit();
	}
}