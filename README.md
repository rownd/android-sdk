# Getting started

This is the SDK for the Rownd Data Privacy Platform.

The Rownd Data Platform allows developers to quickly give their users control over their personal data.  Visit https://rownd.io for more information.

The Rownd Data Platform SDK is easy and fast to use.    Prior to using this SDK, you must register an app on the Rownd platform (https://app.rownd.io), retrieve an App-ID, App Key and Secret, and map personal data-types.    

This SDK covered adding users and their personal data and retrieving end users' data.  The Rownd REST API can be found at https://docs.rownd.io/api/

Rownd docs can be found at https://docs.rownd.io


## Initialization

### Authentication
In order to setup authentication and initialization of the API client, you need the following information.

| Parameter | Description |
|-----------|-------------|
| xRowndAppKey | API Key: Create keys at https://app.rownd.io |
| xRowndAppSecret | API Secret: Create keys at https://app.rownd.io |



API client can be initialized as following. The `appContext` being passed is the Android application [`Context`](https://developer.android.com/reference/android/content/Context.html).

```java
// Configuration parameters and credentials
String xRowndAppKey = ""TODO: Replace""; // API Key: Create keys at https://app.rownd.io
String xRowndAppSecret = ""TODO: Replace""; // API Secret: Create keys at https://app.rownd.io

io.rownd.platform.sdk.Configuration.initialize(appContext);
RowndSdkClient client = new RowndSdkClient(xRowndAppKey, xRowndAppSecret);
```


# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [AddUserDataController](#add_user_data_controller)
* [GetUserDataController](#get_user_data_controller)
* [DeleteUserDataController](#delete_user_data_controller)

## <a name="add_user_data_controller"></a>![Class: ](https://apidocs.io/img/class.png "io.rownd.platform.sdk.controllers.AddUserDataController") AddUserDataController

### Get singleton instance

The singleton instance of the ``` AddUserDataController ``` class can be accessed from the API Client.

```java
AddUserDataController addUserData = client.getAddUserData();
```

### <a name="update_application_user_data_upsert_async"></a>![Method: ](https://apidocs.io/img/method.png "io.rownd.platform.sdk.controllers.AddUserDataController.updateApplicationUserDataUpsertAsync") updateApplicationUserDataUpsertAsync

> Create a user (by entering a new user ID below) or edit an existing user (by passing the previously sent userID) and add data to Rownd.  Note: all data added must be set up in the Rownd Data Privacy and Ownership platform (https://app.rownd.io)


```java
void updateApplicationUserDataUpsertAsync(
        final String app,
        final String user,
        final AppUserData body,
        final APICallBack<AppUserData> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| app |  ``` Required ```  | The ROWND application ID (get it from https://app.rownd.io) |
| user |  ``` Required ```  | This is the ROWND user ID (that app passed to Rownd) |
| body |  ``` Optional ```  | Pass Personal and Private data to the Rownd server.  Please note: Data type must be added to the app in the Rownd Platform (https://app.rownd.io). |


#### Example Usage

```java
try {
    String app = "284454822817563138";
    String user = "testtest123342113";
    String bodyValue = "{\"data\":{\"email\":\"testuser@test1.com\",\"first_name\":\"xxxxxxxx\",\"last_name\":\"xxxxxxxx\",\"cell_phone_number\":\"55555455555\"}}";
    AppUserData body = mapper.readValue(bodyValue,new TypeReference<AppUserData> (){});
    // Invoking the API call with sample inputs
    addUserData.updateApplicationUserDataUpsertAsync(app, user, body, new APICallBack<AppUserData>() {
        public void onSuccess(HttpContext context, AppUserData response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


[Back to List of Controllers](#list_of_controllers)

## <a name="get_user_data_controller"></a>![Class: ](https://apidocs.io/img/class.png "io.rownd.platform.sdk.controllers.GetUserDataController") GetUserDataController

### Get singleton instance

The singleton instance of the ``` GetUserDataController ``` class can be accessed from the API Client.

```java
GetUserDataController getUserData = client.getGetUserData();
```

### <a name="get_application_user_data_get_async"></a>![Method: ](https://apidocs.io/img/method.png "io.rownd.platform.sdk.controllers.GetUserDataController.getApplicationUserDataGetAsync") getApplicationUserDataGetAsync

> For getting one user's data.


```java
void getApplicationUserDataGetAsync(
        final String app,
        final String user,
        final APICallBack<AppUserData> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| app |  ``` Required ```  | The ROWND application ID (get it from https://app.rownd.io) |
| user |  ``` Required ```  | This is the ROWND user ID (that app passed to Rownd) |


#### Example Usage

```java
String app = "1300141209124912d";
String user = "20310948103410djad12332302";
// Invoking the API call with sample inputs
getUserData.getApplicationUserDataGetAsync(app, user, new APICallBack<AppUserData>() {
    public void onSuccess(HttpContext context, AppUserData response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="get_application_user_data_list_async"></a>![Method: ](https://apidocs.io/img/method.png "io.rownd.platform.sdk.controllers.GetUserDataController.getApplicationUserDataListAsync") getApplicationUserDataListAsync

> This is to get all data in an application.


```java
void getApplicationUserDataListAsync(
        final String app,
        final APICallBack<AppUserDataList> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| app |  ``` Required ```  | The ROWND application ID (get it from https://app.rownd.io) |


#### Example Usage

```java
String app = "1300141209124912d";
// Invoking the API call with sample inputs
getUserData.getApplicationUserDataListAsync(app, new APICallBack<AppUserDataList>() {
    public void onSuccess(HttpContext context, AppUserDataList response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


[Back to List of Controllers](#list_of_controllers)

## <a name="delete_user_data_controller"></a>![Class: ](https://apidocs.io/img/class.png "io.rownd.platform.sdk.controllers.DeleteUserDataController") DeleteUserDataController

### Get singleton instance

The singleton instance of the ``` DeleteUserDataController ``` class can be accessed from the API Client.

```java
DeleteUserDataController deleteUserData = client.getDeleteUserData();
```

### <a name="delete_application_user_data_delete_async"></a>![Method: ](https://apidocs.io/img/method.png "io.rownd.platform.sdk.controllers.DeleteUserDataController.deleteApplicationUserDataDeleteAsync") deleteApplicationUserDataDeleteAsync

> To delete a user's ID and data.


```java
void deleteApplicationUserDataDeleteAsync(
        final String app,
        final String user,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| app |  ``` Required ```  | The ROWND application ID (get it from https://app.rownd.io) |
| user |  ``` Required ```  | This is the ROWND user ID (that app passed to Rownd) |


#### Example Usage

```java
String app = "app";
String user = "user";
// Invoking the API call with sample inputs
deleteUserData.deleteApplicationUserDataDeleteAsync(app, user, new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


[Back to List of Controllers](#list_of_controllers)



