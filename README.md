## Architecture

- MVVM
- Multi-Module
- Clean Architecture

## Tech Stack

- Compose
- Coroutine
- Paging3
- Hilt
- retrofit

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
``` kotlin
LazyColumn {
    items(
        items = broads,
        key = { it }
    ){ item ->
}
```
2. ImmutableList 사용
 ```ImmutableList<Broad>```

3. PageConfig의 initialLoadSize를 20으로 설정
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
