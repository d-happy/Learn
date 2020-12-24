void setup() {
  // 1번만 실행할 코드 (설정값)
  pinMode(LED_BUILTIN, OUTPUT); // 내정된 핀번호를 출력용으로 설정
}

void loop() {
  // 무한반복
  digitalWrite(LED_BUILTIN, HIGH);
  // Thread.sleep(1000)
  delay(1000);
  digitalWrite(LED_BUILTIN, LOW);
  delay(1000);
}
