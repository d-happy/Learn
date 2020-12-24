void setup() {
  // 1번만 실행할 코드 (설정값)
  pinMode(13, OUTPUT); // 내정된 핀번호를 출력용으로 설정
  pinMode(7, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(11, OUTPUT);
}

void loop() {
  // 무한반복
  digitalWrite(13, HIGH);
  digitalWrite(7, HIGH);
  
  // Thread.sleep(1000)
  delay(500);
  
  digitalWrite(9, HIGH);
  digitalWrite(11, HIGH);
  
  digitalWrite(13, LOW);
  digitalWrite(7, LOW);
  
  delay(500);

  digitalWrite(9, LOW);
  digitalWrite(11, LOW);
}
