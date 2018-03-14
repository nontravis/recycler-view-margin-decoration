# **「 RecyclerView Margin Decoration 」**

![alt text](./picture/logo.png)

[![Build Status](https://travis-ci.org/TheKhaeng/recycler-view-margin-decoration.svg?branch=master)](https://travis-ci.org/TheKhaeng/recycler-view-margin-decoration) [ ![Download](https://api.bintray.com/packages/nonthawit/TheKhaeng/recycler-margin/images/download.svg) ](https://bintray.com/nonthawit/TheKhaeng/recycler-margin/_latestVersion) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-RecyclerView%20Margin%20Decoration-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/6833)


A library for add margin each item in RecyclerView.

## 「 New UPDATE 」
- _version 1.2.1_ - support RTL language

## 「 DEMO APPLICATION 」

<a href="https://play.google.com/store/apps/details?id=com.thekhaeng.recyclerviewmargindecoration" target="_blank">
<img src="https://storage.googleapis.com/support-kms-prod/D90D94331E54D2005CC8CEE352FF98ECF639" height="60" width="200">
</a>

## 「 Installation 」

Maven
```xml
<dependency>
  <groupId>com.github.thekhaeng</groupId>
  <artifactId>recycler-margin</artifactId>
  <version>1.2.1</version>
  <type>pom</type>
</dependency>
```

Gradle
```gradle
compile ('com.github.thekhaeng:recycler-margin:1.2.1') {
    exclude group: 'com.android.support', module: 'recyclerview-v7'
}
```

## 「 Usage 」

### For LinearLayoutManager
```java
recyclerView.addItemDecoration( new LayoutMarginDecoration( 1, spaceInPx ) );
```

### For GridLayoutManager
```java
recyclerView.addItemDecoration( new LayoutMarginDecoration( yourColumn, spaceInPx ) );
```

### For StaggeredGridLayoutManager
```java
recyclerView.addItemDecoration( new LayoutMarginDecoration( yourColumn, spaceInPx ) );
```

### Set padding

```java
LayoutMarginDecoration layoutMargin = new LayoutMarginDecoration( gridSpan, itemSpace );

layoutMargin.setPadding(recyclerView, top, bottom, left, right );

or

layoutMargin.setPadding(recyclerView, padding );
```

or use **xml**

```xml
<android.support.v7.widget.RecyclerView
    ...
    android:padding="16dp"
    android:clipToPadding="false"
    android:scrollbarStyle="outsideOverlay"
    ...
    />
```


### Click listener
```java
LayoutMarginDecoration layoutMargin = new LayoutMarginDecoration( spaceInPx );

layoutMargin.setOnClickLayoutMarginDecorationItemListener( new OnClickLayoutMarginDecorationItemListener(){
     @Override
     public void onClick( Context context, View v, int position, int spanIndex, RecyclerView.State state ){
         Toast.makeText( context, "item: " + position + "\ncolumn: " + spanIndex, Toast.LENGTH_SHORT ).show();
     }
);
```


# Licence

Copyright 2017 TheKhaeng

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.


### Developed By Thai android developer.


<img src="./picture/profile2_circle.png" width="170">   ![alt text](./picture/thekhaeng_logo.png)


Follow [facebook.com/thekhaeng.io](https://www.facebook.com/thekhaeng.io) on Facebook page.
or [@nonthawit](https://medium.com/@nonthawit) at my Medium blog. :)

For contact, shoot me an email at nonthawit.thekhaeng@gmail.com


