#include<Servo.h>
#include <LiquidCrystal_I2C.h>

Servo myservo; 
int servoPin = 7;
int pos = 0; 
int gg = 0;

LiquidCrystal_I2C lcd(0x3F, 16, 2);

int btn = 12;

int speakerPin = 6;
int numTones = 10; // C ~ E
int tones[] = {
  261, 277, 294, 311, 330, 349, 370, 392, 415, 440
};
 
void setup() 
{ 
  pinMode(btn, INPUT);
  
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(11, OUTPUT);
  myservo.attach(servoPin); 
  pinMode(2, OUTPUT);
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);

  Serial.begin(9600);
  int size = sizeof(tones); // 크기 : 20 bytes
  Serial.println(size / 2);

  lcd.begin();
} 
 
void loop() 
{ 

  lcd.setCursor(5, 0);    // 커서를 5, 0에 가져다 놓아라. (열, 행)
  lcd.print("Hi ^^");     // 5, 0에 Hi ^^를 출력해라.
  delay(1000);            // 1초 대기
  lcd.setCursor(3, 1);    // 커서를 3, 1로 가져다 놓아라. (열, 행)
  lcd.print("Codingrun"); // Codingrun을 입력해라.
  delay(1000);            // 1초 대기 
  lcd.clear();            // 글자를 모두 지워라.
  delay(1000);
  
  for(int i = 0; i < sizeof(tones)/2; i++) {
    tone(speakerPin, tones[i]);
    delay(500);
  }
  noTone(speakerPin);
  delay(1000);
  
  while(true) {
    if (digitalRead(btn) == HIGH) {
      tone(speakerPin, tones[9]);
      delay(500);
      noTone(speakerPin);
    }
    
    delay(500);
    digitalWrite(2, LOW);
    digitalWrite(3, LOW);
    digitalWrite(4, LOW);
    
    for(pos = 0; pos < 180; pos += 1) 
    { 
      myservo.write(pos);
      delay(15); //delay값을 조정하여 모터의 속도를 컨터롤가능
    } 

    analogWrite(9, random(0, 256));
    analogWrite(10, random(100, 256));
    analogWrite(11, random(100, 256));
    delay(100);
    digitalWrite(2, HIGH);
    digitalWrite(3, HIGH);
    digitalWrite(4, HIGH);
    delay(500);
    digitalWrite(2, LOW);
    digitalWrite(3, LOW);
    digitalWrite(4, LOW);
    
    for(pos = 180; pos>=1; pos-=1)
    { 
      myservo.write(pos); 
      delay(15); 
    } 
    
    delay(100);
    digitalWrite(2, HIGH);
    digitalWrite(3, HIGH);
    digitalWrite(4, HIGH);
  }
}
