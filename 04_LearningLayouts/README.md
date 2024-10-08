# Android Layouts

## 1. Layout (레이아웃)이란?
레이아웃은 뷰 그룹(ViewGroup)의 일종으로, 화면에 표시될 뷰(View) 또는 다른 레이아웃을 배치하는 역할을 합니다. 즉, 뷰들의 배치 방식과 구조를 정의하는 컨테이너입니다.

---

## 2. Linear Layout (리니어 레이아웃)
### 2-1. 리니어 레이아웃이란?
리니어 레이아웃은 자식 뷰들을 **수직** 또는 **수평**으로 일렬로 배치하는 레이아웃입니다. 자식 요소들이 일관된 순서로 배열되므로 간단한 배치를 위한 좋은 선택입니다.

### 2-2. `orientation` (방향)
- **orientation** 속성은 자식 뷰가 배열되는 방향을 결정합니다.  
  - `horizontal`: 가로로 배치  
  - `vertical`: 세로로 배치

### 2-3. `layout_gravity`
- 자식 뷰가 자신의 부모 뷰 내에서 어떻게 정렬되는지를 정의합니다. (왼쪽, 오른쪽, 위쪽, 아래쪽 등)

### 2-4. `layout_weight`, `weightSum`
- **layout_weight**: 자식 뷰들의 비율을 설정해 공간을 동적으로 분배합니다.  
- **weightSum**: 리니어 레이아웃 내의 자식 뷰들이 차지하는 전체 비율의 합계를 지정할 수 있습니다.

---

## 3. Relative Layout (상대적 레이아웃)
### 3-1. 상대적 레이아웃이란?
상대적 레이아웃은 자식 뷰들을 서로의 상대적인 위치 또는 부모 레이아웃을 기준으로 배치하는 레이아웃입니다. 다양한 레이아웃 구조를 보다 유연하게 구성할 수 있습니다.

### 3-2. 레이아웃 기준 배치
뷰가 부모 레이아웃 내에서 상대적으로 배치되는 방식입니다. 예를 들어, 부모 레이아웃의 상단 또는 하단을 기준으로 뷰를 배치할 수 있습니다.

### 3-3. 뷰 기준 배치
다른 자식 뷰들의 위치를 기준으로 해당 뷰를 배치할 수 있습니다. 예를 들어, 특정 뷰의 왼쪽, 오른쪽, 위 또는 아래에 배치하는 방식입니다.

---

## 4. Constraint Layout (컨스트레인트 레이아웃)
### 4-1. 컨스트레인트 레이아웃이란?
컨스트레인트 레이아웃은 뷰 간의 제약 조건을 설정해 복잡한 UI를 보다 유연하게 설계할 수 있는 레이아웃입니다. 각 뷰는 **수평 및 수직**으로 제약을 설정하여 배치할 수 있습니다.

#### 컨스트레인트 레이아웃 필수 요소
1. **수평 방향 제약**: 뷰가 수평적으로 어디에 위치할지 설정하는 제약입니다.
2. **수직 방향 제약**: 뷰가 수직적으로 어디에 위치할지 설정하는 제약입니다.

### 4-2. 기본 속성
- **Constraint Layout**에서는 뷰마다 상하좌우 제약을 지정하여 복잡한 레이아웃을 구현할 수 있습니다. 화면에 따른 다양한 배치를 위해 자주 사용됩니다.

### 4-3. `match_constraint`
- 뷰가 부모 레이아웃의 제약 조건에 따라 크기를 동적으로 조절하도록 설정하는 속성입니다.

---

## 5. 반응형 UI 만들기
- 안드로이드에서 반응형 UI는 다양한 화면 크기와 해상도에 맞게 조정되는 UI를 의미합니다. 이를 위해 `ConstraintLayout`과 같은 레이아웃을 사용하여 다양한 디바이스에 최적화된 디자인을 구현할 수 있습니다.
- **반응형 레이아웃 설계**는 `dp`, `sp`와 같은 단위를 사용해 화면 크기에 따른 비율을 유지하고, 다양한 해상도에 적응할 수 있도록 도와줍니다.
