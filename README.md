## Architecture

- MVVM
- Multi-Module
- Clean Architecture

## Tech Stack

- Compose
- Coroutine
- Paging3
- Hilt
- Retrofit

## Package Structure

```java
app
├── ...
├── src
│   ├── app //Application            
│   │                  
presentation
├── ...
├── src
│   ├── presentation 
│   │   ├── theme  //App Theme 정의       
│   │   ├── main   //홈 화면                
│   │   ├── detail //상세 화면 
│   │   │ 
data                                       
├── ...                                     
├── src               
│   ├── data                              
│   │   ├── api //API interface 정의
│   │   ├── di //Dependency Injection Module
│   |   ├── broad // broad enpoint 
│   │   │   ├── datasource                
│   │   │   ├── dto  
│   │   │   ├── mapper                  
│   │   │   ├── paging      
│   │   │   ├── repository
domain                                    
├── ...                                 
├── src                                         
│   ├── domain                                  
│   │   ├── model              
│   │   ├── repository  
│   │   ├── usecase                  
│   │   │                
core
├── ...
├── src
│   ├── core
│   │   ├── android               
│   │   ├── kotlin  
│   │   ├── base                  
│   │   ├── compose      
```
## Description
| 메인                                                       | 상세화면                                                           | 
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![image](https://user-images.githubusercontent.com/70064912/211198022-f13457c0-c82c-453a-8713-7a00ae0fbb2e.png) |![image](https://user-images.githubusercontent.com/70064912/211198027-0619077e-34bb-404a-a2fb-d0517d25aebb.png) |

### 최적화 방안

1. LazyColumn의 key를 지정
- key 속성을 통해 item의 위치를 기억하면 다음 장점들을 가질 수 있음
    - 한 요소가 변화될 때 그 요소만 리컴포지션 됨
    - 순서가 변경되어도 상태를 기억함
``` kotlin
LazyColumn {
    items(
        items = broads,
        key = { it }
    ){ item ->
}
```

<br>

2. ImmutableList 사용 ```ImmutableList<Broad>```
- 만약 List를 사용한다면, List를 인자로 받는 composable은 Stable하지 않다고 컴파일러에게 인식되어 recomposition을 스킵할 수 없음

<br>

3. PageConfig의 initialLoadSize를 20으로 설정
- 사용자가 원하는 Tab을 찾기 전에 스크롤을 많이 내리지 않으므로, 초기 PagingData를 크게 설정할 필요가 없음
```kotlin
config = PagingConfig(
    pageSize = PageSize,
    initialLoadSize = InitialLoadSize,
)
companion object {
    private const val PageSize = 1
    private const val InitialLoadSize = 20
}
```


## Figma Link

|     [https://www.figma.com/file/eugGSn3JdJdv5DT70llcyW/afreeca_assignment?node-id=0%3A1&t=J8v2jsWmWkqhNkLN-1](https://www.figma.com/file/eugGSn3JdJdv5DT70llcyW/afreeca_assignment?node-id=0%3A1&t=J8v2jsWmWkqhNkLN-1)                                             |
| ------------------------------------------------------------ |
| ![image](https://user-images.githubusercontent.com/70064912/211197633-530fc5ce-b1f3-45b8-8660-dd446af402ce.png) | 
