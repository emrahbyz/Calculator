# SOLID – ISP In-Class Exercise

Bu uygulamada çalışan ancak tasarım açısından problemli bir hesap makinesi sistemi verilmiştir.

## Başlangıç

1. Repository'yi bilgisayarınıza clone edin.
2. Projeyi IntelliJ IDEA ile açın.
3. `CalculatorMain.java` sınıfını çalıştırın.
4. Programın mevcut haliyle çalıştığını doğrulayın.

## Görev

Mevcut sınıf ve interface yapısını inceleyiniz.

- Her hesap makinesinin gerçekten ihtiyaç duyduğu operasyonları belirleyiniz.
- Tasarımdaki gereksiz bağımlılıkları tespit ediniz.
- Interface yapısını yeniden tasarlayınız.
- Sınıfları yeni tasarıma göre refactor ediniz.
- Programın mevcut davranışını koruyunuz.
- Yaptığınız tasarım değişikliklerini gerekçelendiriniz.

## Kurallar

Başlangıç kodunun davranışı değiştirilmemelidir.

Çözümünüz yalnızca çalışan bir program değil, tasarım kararları açısından da gerekçelendirilmiş olmalıdır.



---

# Çözüm

## Tespit edilen problem
Orijinal tasarımda tek bir "şişman" `Calculator` interface'i 11 operasyonu (4 aritmetik, 4 bilimsel, 3 bitwise) birlikte tanımlıyordu. Bu nedenle her hesap makinesi, kullanmadığı metotları da implement etmek zorundaydı ve bunları `throw new UnsupportedOperationException()` ile dolduruyordu:

| Sınıf | Gerçekten ihtiyaç duyduğu | Zorla implement ettiği (exception) |
|---|---|---|
| BasicCalculator | add, subtract, multiply, divide | sqrt, log, sin, cos, and, or, xor |
| ScientificCalculator | 4 temel + sqrt, log, sin, cos | and, or, xor |
| ProgrammingCalculator | 4 temel + and, or, xor | sqrt, log, sin, cos |

Bu durum **Interface Segregation Principle (ISP)** ihlalidir: *İstemciler kullanmadıkları metotlara bağımlı olmaya zorlanmamalıdır.* Ayrıca desteklenmeyen bir işlemin çağrılması derleme anında değil, ancak çalışma anında (exception ile) fark edilebiliyordu.

## Yeni tasarım
`Calculator` interface'i sorumluluklara göre üç küçük interface'e ayrıldı:

- `ArithmeticOperations` → add, subtract, multiply, divide
- `ScientificOperations` → sqrt, log, sin, cos
- `BitwiseOperations` → and, or, xor

Sınıflar yalnızca ihtiyaç duydukları interface'leri implement eder:

```java
public class BasicCalculator      implements ArithmeticOperations
public class ScientificCalculator implements ArithmeticOperations, ScientificOperations
public class ProgrammingCalculator implements ArithmeticOperations, BitwiseOperations
```

## Gerekçe
- Hiçbir sınıf artık kullanmadığı bir metodu implement etmiyor; `UnsupportedOperationException` atan metotların tamamı kaldırıldı.
- Desteklenmeyen bir işlem çağrısı (ör. `basic.sqrt(...)`) artık **derleme hatası** verir, çalışma anında patlamaz.
- Bir yetenek grubundaki değişiklik (ör. `tan()` eklenmesi) yalnızca o yeteneği kullanan sınıfları etkiler.
- Yeni bir hesap makinesi türü, mevcut kodu değiştirmeden ilgili interface'leri birleştirerek eklenebilir.

## Davranış
`CalculatorMain` değiştirilmedi; program çıktısı orijinal ile birebir aynıdır:

```
=== BASIC CALCULATOR ===
10 + 5 = 15.0
10 - 5 = 5.0

=== SCIENTIFIC CALCULATOR ===
√25 = 5.0
log(100) = 2.0

=== PROGRAMMING CALCULATOR ===
5 AND 3 = 1
5 OR 3 = 7
5 XOR 3 = 6
```
