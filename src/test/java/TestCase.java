
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utils.Library;
import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCase extends Library{
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromiumdriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = createDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.shafiq.id/");
    }

    @AfterEach
    void tearDown() {
        quitDriver();
    }

    protected WebDriver createDriver() {
        return new ChromeDriver();
    }

    protected void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    void TC0001_Akses_Website() {
        String expectedUrl = "https://www.shafiq.id/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Assertion successful: The Home page has been loaded.");
        } else {
            System.out.println("Assertion failed: The Home page did not load as expected.");
        }
    }

    @Test
    @Order(2)
    void TC0002_Register_Sebagai_Individu() throws InterruptedException {

        WebElement Daftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/div[1]/div[2]/a/span")));
        Daftar.click();

        WebElement DaftarIndividu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://www.shafiq.id/static/images/register/individu.png']")));
        DaftarIndividu.click();

        WebElement Nama = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        Nama.click();
        Nama.sendKeys(""+fakeName);

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.click();
        Email.sendKeys(""+fakeEmail);

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        Password.click();
        Password.sendKeys("11AA22bb;");

        WebElement PasswordConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
        PasswordConfirmation.click();
        PasswordConfirmation.sendKeys("11AA22bb;");

        WebElement SelectionPlatform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='choices__item choices__item--selectable']")));
        SelectionPlatform.click();

        WebElement SelectGoogle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"choices--source_id-item-choice-4\"]")));
        SelectGoogle.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-') and starts-with (@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [ @class =  'recaptcha-checkbox-border']"))).click( );
        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        WebElement ButtonDaftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        ButtonDaftar.click();
    }

    @Test
    @Order(3)
    void TC0003_Register_Sebagai_Perusahaan() throws InterruptedException {


        String expectedUrl = "https://www.shafiq.id/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Assertion successful: The Home page has been loaded.");
        } else {
            System.out.println("Assertion failed: The Home page did not load as expected.");
        }
        WebElement Daftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/div[1]/div[2]/a/span")));
        Daftar.click();
        WebElement DaftarPerusahaan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://www.shafiq.id/static/images/register/korporat.png']")));
        DaftarPerusahaan.click();

        WebElement Nama = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        Nama.click();
        Nama.sendKeys(""+fakeName);

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.click();
        Email.sendKeys(""+fakeEmail);

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        Password.click();
        Password.sendKeys("11AA22bb;");

        WebElement PasswordConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
        PasswordConfirmation.click();
        PasswordConfirmation.sendKeys("11AA22bb;");

        WebElement SelectionPlatform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='choices__item choices__item--selectable']")));
        SelectionPlatform.click();

        WebElement SelectGoogle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"choices--source_id-item-choice-4\"]")));
        SelectGoogle.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-') and starts-with (@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [ @class =  'recaptcha-checkbox-border']"))).click( );
        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        WebElement ButtonDaftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        ButtonDaftar.click();
    }

    @Test
    @Order(4)
    void TC0004_Register_Sebagai_Individu_Dengan_Email_Tidak_Valid() throws InterruptedException {
        WebElement Daftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/div[1]/div[2]/a/span")));
        Daftar.click();

        WebElement DaftarIndividu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://www.shafiq.id/static/images/register/individu.png']")));
        DaftarIndividu.click();

        WebElement Nama = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        Nama.click();
        Nama.sendKeys(""+fakeName);

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.click();
        Email.sendKeys("im"+firstName);

        WebElement AlertEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"parsley-id-7\"]/div")));
        Assert.assertEquals(true,AlertEmail.isDisplayed());
        System.out.println(AlertEmail.getText());

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        Password.click();
        Password.sendKeys("11AA22bb;");

        WebElement PasswordConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
        PasswordConfirmation.click();
        PasswordConfirmation.sendKeys("11AA22bb;");

        WebElement SelectionPlatform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='choices__item choices__item--selectable']")));
        SelectionPlatform.click();

        WebElement SelectGoogle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"choices--source_id-item-choice-4\"]")));
        SelectGoogle.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-') and starts-with (@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [ @class =  'recaptcha-checkbox-border']"))).click( );
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    @Test
    @Order(5)
    void TC0005_Register_Sebagai_Perusahaan_Dengan_Email_Tidak_Valid() throws InterruptedException {
        WebElement Daftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/div[1]/div[2]/a/span")));
        Daftar.click();

        WebElement DaftarPerusahaan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://www.shafiq.id/static/images/register/korporat.png']")));
        DaftarPerusahaan.click();

        WebElement Nama = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        Nama.click();
        Nama.sendKeys(""+fakeName);

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.click();
        Email.sendKeys("im"+firstName);

        WebElement AlertEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"parsley-id-7\"]/div")));
        Assert.assertEquals(true,AlertEmail.isDisplayed());
        System.out.println("Alert! " +AlertEmail.getText());

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        Password.click();
        Password.sendKeys("11AA22bb;");

        WebElement PasswordConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
        PasswordConfirmation.click();
        PasswordConfirmation.sendKeys("11AA22bb;");

        WebElement SelectionPlatform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='choices__item choices__item--selectable']")));
        SelectionPlatform.click();

        WebElement SelectGoogle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"choices--source_id-item-choice-4\"]")));
        SelectGoogle.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-') and starts-with (@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [ @class =  'recaptcha-checkbox-border']"))).click( );
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }
    @Test
    @Order(6)
    void TC0006_Register_Sebagai_Individu_Dengan_Password_Sesuai_Ketentuan() throws InterruptedException {
        WebElement Daftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/div[1]/div[2]/a/span")));
        Daftar.click();

        WebElement DaftarIndividu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://www.shafiq.id/static/images/register/individu.png']")));
        DaftarIndividu.click();

        WebElement Nama = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        Nama.click();
        Nama.sendKeys(""+fakeName);

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.click();
        Email.sendKeys(""+fakeEmail);

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        Password.click();
        Password.sendKeys("11AA;");
        WebElement AlertPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"parsley-id-9\"]/div")));
        Assert.assertEquals(true,AlertPassword.isDisplayed());
        System.out.println("Alert! "+AlertPassword.getText());

        WebElement PasswordConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
        PasswordConfirmation.click();
        PasswordConfirmation.sendKeys("11AA;");

        WebElement SelectionPlatform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='choices__item choices__item--selectable']")));
        SelectionPlatform.click();

        WebElement SelectGoogle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"choices--source_id-item-choice-4\"]")));
        SelectGoogle.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-') and starts-with (@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [ @class =  'recaptcha-checkbox-border']"))).click( );
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }
    @Test
    @Order(7)
    void TC0007_Register_Sebagai_Perusahaan_Dengan_Password_Sesuai_Ketentuan() throws InterruptedException {
        WebElement Daftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/div[1]/div[2]/a/span")));
        Daftar.click();

        WebElement DaftarPerusahaan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://www.shafiq.id/static/images/register/korporat.png']")));
        DaftarPerusahaan.click();

        WebElement Nama = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        Nama.click();
        Nama.sendKeys(""+fakeName);

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.click();
        Email.sendKeys(""+fakeEmail);

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        Password.click();
        Password.sendKeys("11AA;");
        WebElement AlertPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"parsley-id-9\"]/div")));
        Assert.assertEquals(true,AlertPassword.isDisplayed());
        System.out.println("Alert! "+AlertPassword.getText());

        WebElement PasswordConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
        PasswordConfirmation.click();
        PasswordConfirmation.sendKeys("11AA;");

        WebElement SelectionPlatform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='choices__item choices__item--selectable']")));
        SelectionPlatform.click();

        WebElement SelectGoogle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"choices--source_id-item-choice-4\"]")));
        SelectGoogle.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-') and starts-with (@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [ @class =  'recaptcha-checkbox-border']"))).click( );
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    @Test
    @Order(8)
    void TC0008_Register_Sebagai_Individu_Dengan_Konfirmasi_Password_Tidak_Sama() throws InterruptedException {
        WebElement Daftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/div[1]/div[2]/a/span")));
        Daftar.click();

        WebElement DaftarIndividu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://www.shafiq.id/static/images/register/individu.png']")));
        DaftarIndividu.click();

        WebElement Nama = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        Nama.click();
        Nama.sendKeys(""+fakeName);

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.click();
        Email.sendKeys(""+fakeEmail);

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        Password.click();
        Password.sendKeys("11AA22bb;");

        WebElement PasswordConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
        PasswordConfirmation.click();
        PasswordConfirmation.sendKeys("11AA;");

        WebElement AlertPasswordNotSame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //div[@id='parsleyEqualto']")));
        Assert.assertEquals(true,AlertPasswordNotSame.isDisplayed());
        System.out.println("Alert! "+AlertPasswordNotSame.getText());

        WebElement SelectionPlatform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='choices__item choices__item--selectable']")));
        SelectionPlatform.click();

        WebElement SelectGoogle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"choices--source_id-item-choice-4\"]")));
        SelectGoogle.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-') and starts-with (@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [ @class =  'recaptcha-checkbox-border']"))).click( );
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    @Test
    @Order(9)
    void TC0009_Register_Sebagai_Perusahaan_Dengan_Konfirmasi_Password_Tidak_Sama() throws InterruptedException {
        WebElement Daftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/div[1]/div[2]/a/span")));
        Daftar.click();

        WebElement DaftarPerusahaan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://www.shafiq.id/static/images/register/korporat.png']")));
        DaftarPerusahaan.click();

        WebElement Nama = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        Nama.click();
        Nama.sendKeys(""+fakeName);

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.click();
        Email.sendKeys(""+fakeEmail);

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        Password.click();
        Password.sendKeys("11AA22bb;");

        WebElement PasswordConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
        PasswordConfirmation.click();
        PasswordConfirmation.sendKeys("11AA;");

        WebElement AlertPasswordNotSame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //div[@id='parsleyEqualto']")));
        Assert.assertEquals(true,AlertPasswordNotSame.isDisplayed());
        System.out.println("Alert! "+AlertPasswordNotSame.getText());

        WebElement SelectionPlatform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='choices__item choices__item--selectable']")));
        SelectionPlatform.click();

        WebElement SelectGoogle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"choices--source_id-item-choice-4\"]")));
        SelectGoogle.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-') and starts-with (@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [ @class =  'recaptcha-checkbox-border']"))).click( );
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    @Test
    @Order(10)
    void TC0010_Register_Sebagai_Individu_Dengan_Tidak_Memilih_Opsi_Dropdown() throws InterruptedException {
        WebElement Daftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/div[1]/div[2]/a/span")));
        Daftar.click();

        WebElement DaftarIndividu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://www.shafiq.id/static/images/register/individu.png']")));
        DaftarIndividu.click();

        WebElement SelectionPlatform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='choices__item choices__item--selectable']")));
        SelectionPlatform.click();

        WebElement SelectPilihOpsi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"choices--source_id-item-choice-1\"]")));
        SelectPilihOpsi.click();
        WebElement Nama = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        Nama.click();
        Nama.sendKeys(""+fakeName);

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.click();
        Email.sendKeys(""+fakeEmail);

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        Password.click();
        Password.sendKeys("11AA22bb;");

        WebElement PasswordConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
        PasswordConfirmation.click();
        PasswordConfirmation.sendKeys("11AA22bb;");


        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-') and starts-with (@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [ @class =  'recaptcha-checkbox-border']"))).click( );
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    @Test
    @Order(11)
    void TC0011_Register_Sebagai_Perusahaan_Dengan_Tidak_Memilih_Opsi_Dropdown() throws InterruptedException {
        WebElement Daftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/div[1]/div[2]/a/span")));
        Daftar.click();

        WebElement DaftarPerusahaan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://www.shafiq.id/static/images/register/korporat.png']")));
        DaftarPerusahaan.click();

        WebElement SelectionPlatform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='choices__item choices__item--selectable']")));
        SelectionPlatform.click();

        WebElement SelectPilihOpsi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"choices--source_id-item-choice-1\"]")));
        SelectPilihOpsi.click();
        WebElement Nama = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        Nama.click();
        Nama.sendKeys(""+fakeName);

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.click();
        Email.sendKeys(""+fakeEmail);

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        Password.click();
        Password.sendKeys("11AA22bb;");

        WebElement PasswordConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
        PasswordConfirmation.click();
        PasswordConfirmation.sendKeys("11AA22bb;");


        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-') and starts-with (@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [ @class =  'recaptcha-checkbox-border']"))).click( );
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    @Test
    @Order(12)
    void TC0012_Register_Sebagai_Individu_Dengan_Tidak_Mengklik_Checkbox_reCAPTCHA() throws InterruptedException {

        WebElement Daftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/div[1]/div[2]/a/span")));
        Daftar.click();

        WebElement DaftarIndividu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://www.shafiq.id/static/images/register/individu.png']")));
        DaftarIndividu.click();

        WebElement Nama = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        Nama.click();
        Nama.sendKeys(""+fakeName);

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.click();
        Email.sendKeys(""+fakeEmail);

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        Password.click();
        Password.sendKeys("11AA22bb;");

        WebElement PasswordConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
        PasswordConfirmation.click();
        PasswordConfirmation.sendKeys("11AA22bb;");

        WebElement SelectionPlatform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='choices__item choices__item--selectable']")));
        SelectionPlatform.click();

        WebElement SelectGoogle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"choices--source_id-item-choice-4\"]")));
        SelectGoogle.click();

        WebElement ButtonDaftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        ButtonDaftar.click();

        Thread.sleep(3000);
    }

    @Test
    @Order(13)
    void TC0013_Register_Sebagai_Perusahaan_Dengan_Tidak_Mengklik_Checkbox_reCAPTCHA() throws InterruptedException {


        String expectedUrl = "https://www.shafiq.id/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Assertion successful: The Home page has been loaded.");
        } else {
            System.out.println("Assertion failed: The Home page did not load as expected.");
        }
        WebElement Daftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/div[1]/div[2]/a/span")));
        Daftar.click();
        WebElement DaftarPerusahaan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://www.shafiq.id/static/images/register/korporat.png']")));
        DaftarPerusahaan.click();

        WebElement Nama = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        Nama.click();
        Nama.sendKeys(""+fakeName);

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.click();
        Email.sendKeys(""+fakeEmail);

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        Password.click();
        Password.sendKeys("11AA22bb;");

        WebElement PasswordConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
        PasswordConfirmation.click();
        PasswordConfirmation.sendKeys("11AA22bb;");

        WebElement SelectionPlatform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='choices__item choices__item--selectable']")));
        SelectionPlatform.click();

        WebElement SelectGoogle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"choices--source_id-item-choice-4\"]")));
        SelectGoogle.click();

        WebElement ButtonDaftar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        ButtonDaftar.click();
        Thread.sleep(3000);
    }

    @Test
    @Order(14)
    void TC0014_Login_Sebagai_Individu() throws InterruptedException {

        WebElement Masuk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-h4 lg:text-h5']")));
        Masuk.click();

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        Email.click();
        Email.sendKeys(""+fakeEmail);

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        Password.click();
        Password.sendKeys("11AA22bb;");

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-') and starts-with (@src, 'https://www.google.com/recaptcha')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [ @class =  'recaptcha-checkbox-border']"))).click( );
        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        WebElement ButtonMasuk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        ButtonMasuk.click();
    }

    @Test
    @Order(21)
    void TC0021_Search_Dengan_Keyword_Proyek() throws InterruptedException {

        WebElement DaftarInvestasi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/ul/li[2]")));
        DaftarInvestasi.click();

        WebElement Cari = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Cari']")));
        Cari.click();
        Cari.sendKeys("Proyek");
        Cari.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

    }

    @Test
    @Order(22)
    void TC0021_Search_Dengan_Keyword_Perluasan() throws InterruptedException {

        WebElement DaftarInvestasi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/ul/li[2]")));
        DaftarInvestasi.click();

        WebElement Cari = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Cari']")));
        Cari.click();
        Cari.sendKeys("Perluasan");
        Cari.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    @Test
    @Order(23)
    void TC0021_Search_Dengan_Keyword_Pekerjaan() throws InterruptedException {

        WebElement DaftarInvestasi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/ul/li[2]")));
        DaftarInvestasi.click();

        WebElement Cari = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Cari']")));
        Cari.click();
        Cari.sendKeys("Pekerjaan");
        Cari.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    @Test
    @Order(24)
    void TC0024_Filter_Tipe_Saham() throws InterruptedException {

        WebElement DaftarInvestasi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/ul/li[2]")));
        DaftarInvestasi.click();
        Thread.sleep(5000);

        WebElement Filter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-filter text-h4']")));
        Filter.click();

        WebElement Saham = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-filter-investasi\"]/div/div/div/main/div[1]/div[2]/div/div/div[1]/div/div/label")));
        Saham.click();

        WebElement Terapkan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-block btn-primary']")));
        Terapkan.click();
        Thread.sleep(5000);
    }

    @Test
    @Order(25)
    void TC0025_Filter_Tipe_Sukuk_Mudharabah() throws InterruptedException {

        WebElement DaftarInvestasi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/ul/li[2]")));
        DaftarInvestasi.click();
        Thread.sleep(5000);

        WebElement Filter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-filter text-h4']")));
        Filter.click();

        WebElement SukukMudharabah = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-filter-investasi\"]/div/div/div/main/div[1]/div[2]/div/div/div[2]/div/div/label")));
        SukukMudharabah.click();

        WebElement Terapkan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-block btn-primary']")));
        Terapkan.click();
        Thread.sleep(5000);
    }

    @Test
    @Order(28)
    void TC0028_Filter_Urutkan_Nama_A_Z() throws InterruptedException {

        WebElement DaftarInvestasi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offcanvas\"]/ul/li[2]")));
        DaftarInvestasi.click();
        Thread.sleep(5000);
        WebElement Urutkan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"portfolio-feed-panel\"]/div/div[2]/button[2]")));
        Urutkan.click();
        Thread.sleep(2000);
        WebElement A_Z = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-sort-investasi\"]/div/div/div/main/div[2]/div")));
        A_Z.click();
        Thread.sleep(5000);
    }
}