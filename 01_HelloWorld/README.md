# 프로젝트 구조 알아보기

## 1) 프로젝트 구조
- **app 폴더**: 이 폴더에는 앱의 소스코드가 포함되어 있습니다.
- **Gradle Scripts 폴더**: 이 폴더에는 빌드에 필요한 설정 정보들이 들어있습니다.

## 2) 토막 상식

### Gradle이란?
Gradle은 빌드 프로세스를 자동화해주는 툴입니다. 빌드, 테스트, 배포 등 여러 단계를 자동으로 처리해 줍니다.

### 프로젝트와 모듈의 차이점
- **프로젝트**: 전체 폴더 구조로, 여러 모듈을 포함할 수 있습니다.
- **모듈**: 실제 소스코드가 작성된 개별 단위로, 하나의 모듈은 여러 기능이나 라이브러리를 포함할 수 있습니다.

### SDK 레벨
- **compileSdk**: 앱을 어떤 안드로이드 SDK 버전으로 컴파일할 것인지를 나타냅니다. 개발 당시 최신 API 버전으로 설정하는 것이 권장됩니다.
  
- **minSdk**: 앱이 동작할 수 있는 최소한의 API 레벨을 지정합니다. 이 값보다 낮은 버전의 기기에서는 앱이 실행되지 않습니다.
  
- **targetSdk**: 앱이 기기에서 동작할 때 사용하는 API 레벨을 의미하며, 앱이 테스트된 API 레벨을 설정하는 것이 일반적입니다.
