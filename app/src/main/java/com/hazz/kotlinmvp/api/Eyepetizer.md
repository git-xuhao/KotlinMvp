# 开眼 #

- [首页](#home)
	- [视频](#home_video)
	- [textFooter](#home_textFooter)
	- [videoCollectionWithCover](#home_videoCollectionWithCover)
	- [textHeader](#home_textHeader)
	- [videoCollectionOfFollow](#home_videoCollectionOfFollow)
- [发现](#discovery)
	- [热门](#hot)
		- [horizontalScrollCard](#hot_horizontalScrollCard)
		- [squareCardCollection](#hot_squareCardCollection)
		- [textHeader](#hot_textHeader)
	- [分类](#category)
		- [squareCardCollection](#category_squareCardCollection)
		- [bannerCollection](#category_bannerCollection)
		- [videoCollectionOfHorizontalScrollCard](#category_videoCollectionOfHorizontalScrollCard)
	- [作者](#hot)
		- [leftAlignTextHeader](#author_leftAlignTextHeader)
		- [blankCard](#author_blankCard)
		- [videoCollectionWithBrief](#author_videoCollectionWithBrief)
		- [briefCard](#author_briefCard)
- [关注](#follow)
	- [videoCollectionWithBrief](#follow_videoCollectionWithBrief)
	- [videoCollectionOfHorizontalScrollCard](#follow_videoCollectionOfHorizontalScrollCard)

<h2 id="home">首页</h2>

url：[`http://baobab.kaiyanapp.com/api/v4/tabs/selected`](http://baobab.kaiyanapp.com/api/v4/tabs/selected)

拼接参数：

- `udid`：用户唯一标识。该参数可为空也可去除
- `vc`：???，固定值`168`。该参数可为空也可去除
- `vn`：客户端版本。该参数可为空也可去除
- `deviceModel`：手机信息。该参数可为空也可去除
- `first_channel`：???，固定值 `eyepetizer_baidu_market`。该参数可为空也可去除
- `last_channel`：???，固定值 `eyepetizer_baidu_market`。该参数可为空也可去除
- `system_version_code`：手机系统版本。该参数可为空也可去除

url 示例：[`http://baobab.kaiyanapp.com/api/v4/tabs/selected?udid=11111&vc=168&vn=3.3.1&deviceModel=Huawei%36&first_channel=eyepetizer_baidu_market&last_channel=eyepetizer_baidu_market&system_version_code=20`](http://baobab.kaiyanapp.com/api/v4/tabs/selected?udid=11111&vc=168&vn=3.3.1&deviceModel=Huawei%36&first_channel=eyepetizer_baidu_market&last_channel=eyepetizer_baidu_market&system_version_code=20) 或 [`http://baobab.kaiyanapp.com/api/v4/tabs/selected`](http://baobab.kaiyanapp.com/api/v4/tabs/selected)

json 示例：

	{
      "itemList": [
        {
          "type": "video",
          "data": {
            "dataType": "VideoBeanForClient",
            "id": 14914,
            "title": "「在这世界的角落」中文预告",
            "description": "画家河野史代的代表作「この世界の片隅に」是日本近期口碑爆棚的作品，描述了主角们在二战中艰难生存，在残酷的命运中感受温暖人性的感人故事。From Hong Kong Movie 香港電影",
            "provider": {
              "name": "YouTube",
              "alias": "youtube",
              "icon": "http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"
            },
            "category": "预告",
            "author": null,
            "cover": {
              "feed": "http://img.kaiyanapp.com/044b497b10de3542eb6ab3794e45e0e3.jpeg?imageMogr2/quality/60/format/jpg",
              "detail": "http://img.kaiyanapp.com/044b497b10de3542eb6ab3794e45e0e3.jpeg?imageMogr2/quality/60/format/jpg",
              "blurred": "http://img.kaiyanapp.com/7a87195b8f0d42a4d0afd214e6da5038.jpeg?imageMogr2/quality/60/format/jpg",
              "sharing": null
            },
            "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14914&editionType=default&source=ucloud",
            "duration": 0,
            "webUrl": {
              "raw": "http://www.eyepetizer.net/detail.html?vid=14914",
              "forWeibo": "http://wandou.im/3m6n3o"
            },
            "releaseTime": 1488330000000,
            "playInfo": [
              {
                "height": 480,
                "width": 854,
                "urlList": [
                  {
                    "name": "ucloud",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14914&editionType=normal&source=ucloud"
                  },
                  {
                    "name": "qcloud",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14914&editionType=normal&source=qcloud"
                  }
                ],
                "name": "标清",
                "type": "normal",
                "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14914&editionType=normal&source=ucloud"
              },
              {
                "height": 720,
                "width": 1280,
                "urlList": [
                  {
                    "name": "ucloud",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14914&editionType=high&source=ucloud"
                  },
                  {
                    "name": "qcloud",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14914&editionType=high&source=qcloud"
                  }
                ],
                "name": "高清",
                "type": "high",
                "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14914&editionType=high&source=ucloud"
              }
            ],
            "consumption": {
              "collectionCount": 483,
              "shareCount": 595,
              "replyCount": 24
            },
            "campaign": null,
            "waterMarks": null,
            "adTrack": null,
            "tags": [
              {
                "id": 136,
                "name": "温情",
                "actionUrl": "eyepetizer://tag/136/?title=%E6%B8%A9%E6%83%85",
                "adTrack": null
              },
              {
                "id": 350,
                "name": "日本",
                "actionUrl": "eyepetizer://tag/350/?title=%E6%97%A5%E6%9C%AC",
                "adTrack": null
              },
              {
                "id": 22,
                "name": "预告",
                "actionUrl": "eyepetizer://tag/22/?title=%E9%A2%84%E5%91%8A",
                "adTrack": null
              },
              {
                "id": 14,
                "name": "动画",
                "actionUrl": "eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB",
                "adTrack": null
              },
              {
                "id": 58,
                "name": "2D",
                "actionUrl": "eyepetizer://tag/58/?title=2D",
                "adTrack": null
              },
              {
                "id": 526,
                "name": "战争",
                "actionUrl": "eyepetizer://tag/526/?title=%E6%88%98%E4%BA%89",
                "adTrack": null
              },
              {
                "id": 174,
                "name": "治愈",
                "actionUrl": "eyepetizer://tag/174/?title=%E6%B2%BB%E6%84%88",
                "adTrack": null
              },
              {
                "id": 510,
                "name": "励志",
                "actionUrl": "eyepetizer://tag/510/?title=%E5%8A%B1%E5%BF%97",
                "adTrack": null
              }
            ],
            "type": "NORMAL",
            "idx": 0,
            "shareAdTrack": null,
            "favoriteAdTrack": null,
            "webAdTrack": null,
            "date": 1488330000000,
            "promotion": null,
            "label": null,
            "collected": false,
            "played": false
          }
        },
        {
          "type": "textFooter",
          "data": {
            "dataType": "TextFooter",
            "text": "查看往期编辑精选",
            "font": "normal",
            "actionUrl": "eyepetizer://feed?issueIndex=1",
            "adTrack": null
          }
        },
        {
          "type": "videoCollectionWithCover",
          "data": {
            "dataType": "ItemCollection",
            "header": {
              "id": 130,
              "title": null,
              "font": "normal",
              "cover": "http://img.kaiyanapp.com/a366c422fe5765e8fd41ac542ff2607b.jpeg?imageMogr2/quality/60/format/jpg",
              "label": {
                "text": null,
                "card": null,
                "detail": null
              },
              "actionUrl": "eyepetizer://webview/?title=%E4%BB%8A%E5%A4%9C%E6%97%A0%E4%BA%BA%E5%85%A5%E7%9D%A1%EF%BC%8C%E5%A4%B1%E7%9C%A0%E8%BF%9B%E8%A1%8C%E6%97%B6&url=http%3A%2F%2Fwww.eyepetizer.net%2Fvideos_article.html%3Fnid%3D130%26shareable%3Dtrue"
            },
            "itemList": [
              {
                "category": "动画",
                "author": null,
                "cover": {
                  "feed": "http://img.kaiyanapp.com/27dfd1d62de596185a501be6acd0d2b6.jpeg?imageMogr2/quality/60",
                  "detail": "http://img.kaiyanapp.com/27dfd1d62de596185a501be6acd0d2b6.jpeg?imageMogr2/quality/60",
                  "blurred": "http://img.kaiyanapp.com/012061015cb8fa87f01e960a5397b14e.jpeg?imageMogr2/quality/60",
                  "sharing": null
                },
                "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9528&editionType=default&source=ucloud",
                "duration": 161,
                "webUrl": {
                  "raw": "http://www.eyepetizer.net/detail.html?vid=9528",
                  "forWeibo": "http://www.wandoujia.com/eyepetizer/detail.html?vid=9528"
                },
                "releaseTime": 1477962000000,
                "playInfo": [
                  {
                    "height": 480,
                    "width": 854,
                    "urlList": [
                      {
                        "name": "ucloud",
                        "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9528&editionType=normal&source=ucloud"
                      },
                      {
                        "name": "qcloud",
                        "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9528&editionType=normal&source=qcloud"
                      }
                    ],
                    "name": "标清",
                    "type": "normal",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9528&editionType=normal&source=ucloud"
                  },
                  {
                    "height": 720,
                    "width": 1280,
                    "urlList": [
                      {
                        "name": "ucloud",
                        "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9528&editionType=high&source=ucloud"
                      },
                      {
                        "name": "qcloud",
                        "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9528&editionType=high&source=qcloud"
                      }
                    ],
                    "name": "高清",
                    "type": "high",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9528&editionType=high&source=ucloud"
                  }
                ],
                "consumption": {
                  "collectionCount": 831,
                  "shareCount": 1135,
                  "replyCount": 21
                },
                "campaign": null,
                "waterMarks": null,
                "adTrack": null,
                "tags": [
                  {
                    "id": 14,
                    "name": "动画",
                    "actionUrl": "eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB",
                    "adTrack": null
                  },
                  {
                    "id": 56,
                    "name": "3D",
                    "actionUrl": "eyepetizer://tag/56/?title=3D",
                    "adTrack": null
                  },
                  {
                    "id": 134,
                    "name": "反转",
                    "actionUrl": "eyepetizer://tag/134/?title=%E5%8F%8D%E8%BD%AC",
                    "adTrack": null
                  },
                  {
                    "id": 152,
                    "name": "童趣",
                    "actionUrl": "eyepetizer://tag/152/?title=%E7%AB%A5%E8%B6%A3",
                    "adTrack": null
                  }
                ],
                "type": "NORMAL",
                "idx": 0,
                "shareAdTrack": null,
                "favoriteAdTrack": null,
                "webAdTrack": null,
                "date": 1477962000000,
                "promotion": null,
                "label": null,
                "collected": false,
                "played": false
              }
            ],
            "count": 1,
            "adTrack": null
          }
        },
        {
          "type": "textHeader",
          "data": {
            "dataType": "TextHeader",
            "text": "- Feb. 28, Supper -",
            "font": "lobster",
            "adTrack": null
          }
        },
        {
          "type": "video",
          "data": {
            "dataType": "VideoBeanForClient",
            "id": 14881,
            "title": "最佳特效居然不是「海边的曼彻斯特」",
            "description": "当电影「奇幻森林」在昨日荣获第 89 届奥斯卡奖后，恶搞团队 Funny Or Die 表示这些特效技能都弱爆了，他们决定来自发的「揭秘」一下奥斯卡提名文艺片「海边的曼彻斯特」的特效幕后……From Funny Or Die",
            "provider": {
              "name": "YouTube",
              "alias": "youtube",
              "icon": "http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"
            },
            "category": "搞笑",
            "author": null,
            "cover": {
              "feed": "http://img.kaiyanapp.com/280e84cefa5a9b9548104bc60af91066.jpeg?imageMogr2/quality/60/format/jpg",
              "detail": "http://img.kaiyanapp.com/280e84cefa5a9b9548104bc60af91066.jpeg?imageMogr2/quality/60/format/jpg",
              "blurred": "http://img.kaiyanapp.com/d7f7cc019e60833f30100e1c64a37be7.jpeg?imageMogr2/quality/60/format/jpg",
              "sharing": null
            },
            "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14881&editionType=default&source=ucloud",
            "duration": 66,
            "webUrl": {
              "raw": "http://www.eyepetizer.net/detail.html?vid=14881",
              "forWeibo": "http://wandou.im/3m6isi"
            },
            "releaseTime": 1488286800000,
            "playInfo": [
              {
                "height": 480,
                "width": 854,
                "urlList": [
                  {
                    "name": "ucloud",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14881&editionType=normal&source=ucloud"
                  },
                  {
                    "name": "qcloud",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14881&editionType=normal&source=qcloud"
                  }
                ],
                "name": "标清",
                "type": "normal",
                "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14881&editionType=normal&source=ucloud"
              },
              {
                "height": 720,
                "width": 1280,
                "urlList": [
                  {
                    "name": "ucloud",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14881&editionType=high&source=ucloud"
                  },
                  {
                    "name": "qcloud",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14881&editionType=high&source=qcloud"
                  }
                ],
                "name": "高清",
                "type": "high",
                "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14881&editionType=high&source=ucloud"
              }
            ],
            "consumption": {
              "collectionCount": 385,
              "shareCount": 346,
              "replyCount": 37
            },
            "campaign": null,
            "waterMarks": null,
            "adTrack": null,
            "tags": [
              {
                "id": 516,
                "name": "恶搞",
                "actionUrl": "eyepetizer://tag/516/?title=%E6%81%B6%E6%90%9E",
                "adTrack": null
              },
              {
                "id": 54,
                "name": "VFX",
                "actionUrl": "eyepetizer://tag/54/?title=VFX",
                "adTrack": null
              },
              {
                "id": 140,
                "name": "搞笑",
                "actionUrl": "eyepetizer://tag/140/?title=%E6%90%9E%E7%AC%91",
                "adTrack": null
              },
              {
                "id": 172,
                "name": "什么鬼",
                "actionUrl": "eyepetizer://tag/172/?title=%E4%BB%80%E4%B9%88%E9%AC%BC",
                "adTrack": null
              },
              {
                "id": 656,
                "name": "幕后",
                "actionUrl": "eyepetizer://tag/656/?title=%E5%B9%95%E5%90%8E",
                "adTrack": null
              }
            ],
            "type": "NORMAL",
            "idx": 0,
            "shareAdTrack": null,
            "favoriteAdTrack": null,
            "webAdTrack": null,
            "date": 1488286800000,
            "promotion": null,
            "label": null,
            "collected": false,
            "played": false
          }
        },
        {
          "type": "videoCollectionOfFollow",
          "data": {
            "dataType": "ItemCollection",
            "header": {
              "id": 0,
              "title": "热门作者 / 精选分类关注推荐",
              "font": "bold",
              "cover": "http://img.kaiyanapp.com/2d5b6990c04ec7a21d77779eabed7b3f.png",
              "label": null,
              "actionUrl": "eyepetizer://pgcs/all",
              "iconList": [
                "http://img.kaiyanapp.com/a77788d2c4a7e823e87ffb3685697ba8.jpeg?imageMogr2/quality/60",
                "http://img.kaiyanapp.com/70716e90178d2ea35be9e550c26795f1.jpeg",
                "http://img.kaiyanapp.com/657383baf9fd839ece40797738b5a352.jpeg"
              ],
              "description": "微软 XBOX / VICE 中国 / Lens"
            },
            "itemList": [
              {
                "type": "video",
                "data": {
                  "dataType": "VideoBeanForClient",
                  "id": 9616,
                  "title": "Ken Block 的 GYMKHANA NINE 赛道",
                  "description": "Hoonigan 和「极限竞速3」一起，骄傲地发布  Ken Block 的Gymkhana NINE 赛道。",
                  "provider": {
                    "name": "定制来源",
                    "alias": "CustomSrc",
                    "icon": ""
                  },
                  "category": "游戏",
                  "author": {
                    "id": 330,
                    "icon": "http://img.kaiyanapp.com/a77788d2c4a7e823e87ffb3685697ba8.jpeg?imageMogr2/quality/60",
                    "name": "微软 XBOX",
                    "description": "微软 XBOX 最新游戏视频与资讯",
                    "link": "",
                    "latestReleaseTime": 1488367300000,
                    "videoNum": 12,
                    "adTrack": null,
                    "follow": {
                      "itemType": "author",
                      "itemId": 330,
                      "followed": false
                    },
                    "authorType": "MOCK"
                  },
                  "cover": {
                    "feed": "http://img.kaiyanapp.com/e3fd8a154f1f0d36f1a14b42b07fd0c1.jpeg?imageMogr2/quality/60/format/jpg",
                    "detail": "http://img.kaiyanapp.com/e3fd8a154f1f0d36f1a14b42b07fd0c1.jpeg?imageMogr2/quality/60/format/jpg",
                    "blurred": "http://img.kaiyanapp.com/fcef36c7773f10340511000f0a5d645f.jpeg?imageMogr2/quality/60/format/jpg",
                    "sharing": null
                  },
                  "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=default&source=ucloud",
                  "duration": 491,
                  "webUrl": {
                    "raw": "http://www.eyepetizer.net/detail.html?vid=9616",
                    "forWeibo": "http://www.wandoujia.com/eyepetizer/detail.html?vid=9616"
                  },
                  "releaseTime": 1488367300000,
                  "playInfo": [
                    {
                      "height": 480,
                      "width": 854,
                      "urlList": [
                        {
                          "name": "ucloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=normal&source=ucloud"
                        },
                        {
                          "name": "qcloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=normal&source=qcloud"
                        }
                      ],
                      "name": "标清",
                      "type": "normal",
                      "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=normal&source=ucloud"
                    },
                    {
                      "height": 720,
                      "width": 1280,
                      "urlList": [
                        {
                          "name": "ucloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=high&source=ucloud"
                        },
                        {
                          "name": "qcloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=high&source=qcloud"
                        }
                      ],
                      "name": "高清",
                      "type": "high",
                      "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=high&source=ucloud"
                    }
                  ],
                  "consumption": {
                    "collectionCount": 1576,
                    "shareCount": 3205,
                    "replyCount": 64
                  },
                  "campaign": null,
                  "waterMarks": null,
                  "adTrack": null,
                  "tags": [
                    {
                      "id": 4,
                      "name": "运动",
                      "actionUrl": "eyepetizer://tag/4/?title=%E8%BF%90%E5%8A%A8",
                      "adTrack": null
                    },
                    {
                      "id": 296,
                      "name": "赛车",
                      "actionUrl": "eyepetizer://tag/296/?title=%E8%B5%9B%E8%BD%A6",
                      "adTrack": null
                    },
                    {
                      "id": 314,
                      "name": "漂移",
                      "actionUrl": "eyepetizer://tag/314/?title=%E6%BC%82%E7%A7%BB",
                      "adTrack": null
                    }
                  ],
                  "type": "NORMAL",
                  "idx": 0,
                  "shareAdTrack": null,
                  "favoriteAdTrack": null,
                  "webAdTrack": null,
                  "date": 1488367300000,
                  "promotion": null,
                  "label": null,
                  "collected": false,
                  "played": false
                }
              }
            ],
            "count": 1,
            "adTrack": null
          }
        }
      ],
      "count": 6,
      "total": 0,
      "nextPageUrl": "http://baobab.kaiyanapp.com/api/v4/tabs/selected?date=1488243600000&num=2&page=2",
      "date": 1488330000000,
      "nextPublishTime": 1488373200000,
      "dialog": null
    }

json 解析：
`itemList` 内容可根据 `type` 和 `dataType` 分成5种类型

<h3 id="home_video">视频</h3>

- `type`：类型，固定值 `video`
- `data`：具体数据
	- `dataType`：数据类型，固定值 `VideoBeanForClient`
	- `id`：视频 id
	- `title`：标题
	- `description`：简易描述
	- `provider`：内容提供商信息
	- `category`：分类
	- `author`：作者
	- `cover`：背景图信息
	- `playUrl`：视频播放地址
	- `duration`：播放时长
	- `webUrl`：网页链接
	- `playInfo`：视频的几种播放选择
		- `height`：视频高度
		- `width`：视频宽度
		- `urlList`：播放链接
		- `name`：视频清晰度
	- `consumption`
		- `collectionCount`：多少人收藏
		- `shareCount`：多少人分享
		- `replyCount`：多少人回复
	- `tags`：视频标签
		- `id`：分类的 id
		- `name`：分类的名称
		- `actionUrl`：分类的 url

<h3 id="home_textFooter">textFooter</h3>

- `type`：类型，固定值 `textFooter`
- `data`：具体数据
	- `text`：信息
	- `actionUrl`：需要拼接的 url

<h3 id="home_videoCollectionWithCover">videoCollectionWithCover</h3>

- `type`：类型，固定值 `videoCollectionWithCover`
- `data`：具体数据
	- `dataType`：数据类型，取值 `ItemCollection`
	- `header`：内容
		- `id`：
		- `font`：字体信息
		- `cover`：背景图信息
		- `actionUrl`：需要拼接的 url
	- `itemList`
		- // 等同[视频](#home_video)
	- `count`：`itemList` 长度，即返回数据的总长度

<h3 id="home_textHeader">textHeader</h3>

同[textFooter](#home_textFooter)

<h3 id="home_videoCollectionOfFollow">home_videoCollectionOfFollow</h3>

- `type`：类型，固定值 `videoCollectionOfFollow`
- `data`：具体数据
	- `dataType`：数据类型，取值 `ItemCollection`
		- `header`：内容
			- `id`：
			- `title`：标题
			- `font`：字体信息
			- `cover`：背景图信息
			- `iconList`：嵌入的小图 url
			- `actionUrl`：需要拼接的 url
			- `description`：简易描述
		- `itemList`
			- // 等同[视频](#home_video)
		- `count`：`itemList` 长度，即返回数据的总长度
- `count`：`itemList` 长度，即返回数据的总长度
- `nextPageUrl`：加载下一页的 url
- `date`：日期
- `nextPublishTime`：下次更新日期

<h2 id="discovery">发现</h2>

<h3 id="title">获取分类</h3>

url：[`http://baobab.kaiyanapp.com/api/v4/discovery`](http://baobab.kaiyanapp.com/api/v4/discovery)

拼接参数：

- `udid`：用户唯一标识。该参数可为空也可去除
- `vc`：???，固定值`168`。该参数可为空也可去除
- `vn`：客户端版本。该参数可为空也可去除
- `deviceModel`：手机信息。该参数可为空也可去除
- `first_channel`：???，固定值 `eyepetizer_baidu_market`。该参数可为空也可去除
- `last_channel`：???，固定值 `eyepetizer_baidu_market`。该参数可为空也可去除
- `system_version_code`：手机系统版本。该参数可为空也可去除

url 示例：[`http://baobab.kaiyanapp.com/api/v4/discovery?udid=11111&vc=168&vn=3.3.1&deviceModel=Huawei%36&first_channel=eyepetizer_baidu_market&last_channel=eyepetizer_baidu_market&system_version_code=20`](http://baobab.kaiyanapp.com/api/v4/discovery?udid=11111&vc=168&vn=3.3.1&deviceModel=Huawei%36&first_channel=eyepetizer_baidu_market&last_channel=eyepetizer_baidu_market&system_version_code=20) 或 [`http://baobab.kaiyanapp.com/api/v4/discovery`](http://baobab.kaiyanapp.com/api/v4/discovery)

json 示例：

	{
      "tabInfo": {
        "tabList": [
          {
            "id": 0,
            "name": "热门",
            "apiUrl": "http://baobab.kaiyanapp.com/api/v4/discovery/hot"
          },
          {
            "id": 1,
            "name": "分类",
            "apiUrl": "http://baobab.kaiyanapp.com/api/v4/discovery/category"
          },
          {
            "id": 2,
            "name": "作者",
            "apiUrl": "http://baobab.kaiyanapp.com/api/v4/pgcs/all"
          }
        ],
        "defaultIdx": 0
      }
    }

json 解析：

- `id`：id
- `name`：分类名
- `apiUrl`：该分类详细内容 url
- `defaultIdx`：???

<h3 id="hot">热门</h3>

url 从[获取分类](#title)中获取

json 示例：

	{
      "itemList": [
        {
          "type": "horizontalScrollCard",
          "data": {
            "dataType": "HorizontalScrollCard",
            "itemList": [
              {
                "type": "banner2",
                "data": {
                  "dataType": "Banner",
                  "id": 299,
                  "title": "",
                  "description": "",
                  "image": "http://img.kaiyanapp.com/0a21eb5fc236cab231b94ba3471642ca.jpeg?imageMogr2/quality/60/format/jpg",
                  "actionUrl": "eyepetizer://webview/?title=%E8%BF%99%E6%98%AF%E4%B8%80%E4%BB%BD%E5%80%BC%E5%BE%97%E6%94%B6%E8%97%8F%E7%9A%84%E7%89%87%E5%8D%95&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1061%26shareable%3Dtrue",
                  "adTrack": null,
                  "shade": false,
                  "label": {
                    "text": null,
                    "card": null,
                    "detail": null
                  }
                }
              }
            ],
            "count": 1
          }
        },
        {
          "type": "textHeader",
          "data": {
            "dataType": "TextHeader",
            "text": "近期热门",
            "font": "bold",
            "adTrack": null
          }
        },
        {
          "type": "video",
          "data": {
            "dataType": "VideoBeanForClient",
            "id": 14796,
            "title": "震撼你的视野新版行星及恒星的大小对比",
            "description": "该视频展现了行星及恒星的大小对比！整个画面十分震撼，人类，不太阳系真的太渺小了！",
            "provider": {
              "name": "PGC",
              "alias": "PGC",
              "icon": ""
            },
            "category": "科普",
            "author": {
              "id": 400,
              "icon": "http://img.kaiyanapp.com/1c4b7194935f0351cde3916e35479e1f.jpeg?imageMogr2/quality/60/format/jpg",
              "name": "天文一族",
              "description": "专注于对宇宙、太空、星系等天文科学知识的分享及科普！",
              "link": "",
              "latestReleaseTime": 1488258461000,
              "videoNum": 23,
              "adTrack": null,
              "follow": {
                "itemType": "author",
                "itemId": 400,
                "followed": false
              },
              "authorType": "NORMAL"
            },
            "cover": {
              "feed": "http://img.kaiyanapp.com/3586a5420e4803557e221d5ebaeb8d04.png?imageMogr2/quality/60/format/jpg",
              "detail": "http://img.kaiyanapp.com/3586a5420e4803557e221d5ebaeb8d04.png?imageMogr2/quality/60/format/jpg",
              "blurred": "http://img.kaiyanapp.com/cee6447d64899aeba600fc91a2081d7a.jpeg?imageMogr2/quality/60/format/jpg",
              "sharing": null
            },
            "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=default&source=ucloud",
            "duration": 378,
            "webUrl": {
              "raw": "http://www.eyepetizer.net/detail.html?vid=14796",
              "forWeibo": "http://wandou.im/3m62x5"
            },
            "releaseTime": 1488162878000,
            "playInfo": [
              {
                "height": 480,
                "width": 854,
                "urlList": [
                  {
                    "name": "ucloud",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=normal&source=ucloud"
                  },
                  {
                    "name": "qcloud",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=normal&source=qcloud"
                  }
                ],
                "name": "标清",
                "type": "normal",
                "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=normal&source=ucloud"
              },
              {
                "height": 720,
                "width": 1280,
                "urlList": [
                  {
                    "name": "ucloud",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=high&source=ucloud"
                  },
                  {
                    "name": "qcloud",
                    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=high&source=qcloud"
                  }
                ],
                "name": "高清",
                "type": "high",
                "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=high&source=ucloud"
              }
            ],
            "consumption": {
              "collectionCount": 426,
              "shareCount": 454,
              "replyCount": 15
            },
            "campaign": null,
            "waterMarks": null,
            "adTrack": null,
            "tags": [],
            "type": "NORMAL",
            "idx": 0,
            "shareAdTrack": null,
            "favoriteAdTrack": null,
            "webAdTrack": null,
            "date": 1488162878000,
            "promotion": null,
            "label": null,
            "collected": false,
            "played": false
          }
        },
        {
          "type": "squareCardCollection",
          "data": {
            "dataType": "ItemCollection",
            "header": {
              "id": 2,
              "title": "热门排行",
              "font": "bold",
              "cover": null,
              "label": null,
              "actionUrl": "eyepetizer://ranklist/"
            },
            "itemList": [
              {
                "type": "squareCard",
                "data": {
                  "dataType": "SquareCard",
                  "id": 1,
                  "title": "",
                  "image": "http://img.kaiyanapp.com/5992fbf7468c2174a31fb7b438ebd414.jpeg?imageMogr2/quality/60",
                  "actionUrl": "eyepetizer://ranklist/?type=Weekly",
                  "shade": false,
                  "adTrack": null
                }
              },
              {
                "type": "squareCard",
                "data": {
                  "dataType": "SquareCard",
                  "id": 2,
                  "title": "",
                  "image": "http://img.kaiyanapp.com/33a59b02f3d8e57831844b54771f72d6.jpeg?imageMogr2/quality/60",
                  "actionUrl": "eyepetizer://ranklist/?type=Monthly",
                  "shade": false,
                  "adTrack": null
                }
              },
              {
                "type": "squareCard",
                "data": {
                  "dataType": "SquareCard",
                  "id": 3,
                  "title": "",
                  "image": "http://img.kaiyanapp.com/9fb34512de6d12a6b22d821079d06ff3.jpeg?imageMogr2/quality/60",
                  "actionUrl": "eyepetizer://ranklist/?type=Historical",
                  "shade": false,
                  "adTrack": null
                }
              },
              {
                "type": "actionCard",
                "data": {
                  "dataType": "ActionCard",
                  "id": 0,
                  "text": "查看全部",
                  "actionUrl": "eyepetizer://ranklist/",
                  "adTrack": null
                }
              }
            ],
            "count": 4,
            "adTrack": null
          }
        },
        {
          "type": "textHeader",
          "data": {
            "dataType": "TextHeader",
            "text": "最新发布",
            "font": "bold",
            "adTrack": null
          }
        }
      ],
      "count": 4,
      "total": 0,
      "nextPageUrl": null
    }


json 解析：
除了新增的几个类型之外，其他类型和[首页](#home)中的相同

<h4 id="hot_horizontalScrollCard">horizontalScrollCard</h4>

- `type`：固定值 `horizontalScrollCard`
- `data`
	- `dataType`：固定值 `HorizontalScrollCard`
	- `count`：`itemList` 长度
	- `itemList`：横向播放的数据列表
		- `data`
			- `id`：id
			- `title`：标题信息
			- `image`：图片信息
			- `description`：简易描述
			- `actionUrl`：拼接的 url

<h4 id="hot_squareCardCollection">squareCardCollection</h4>

- `type`：固定值 `squareCardCollection`
- `data`
	- `dataType`：固定值 `ItemCollection`
	- `header`：
		- `title`：标题信息
	- `itemList`：数据列表
		- `type`：固定值 `squareCard`
		- `data`
			- `title`：标题信息
			- `image`：图片信息
			- `actionUrl`：拼接的 url
<h4 id="hot_textHeader">textHeader</h4>

- `type`：固定值 `squareCardCollection`
- `data`
	- `dataType`	：固定值 `ItemCollection`
	// 其他字段与上相同

<h3 id="category">分类</h3>

url 从[获取分类](#title)中获取

json 示例：

	{
      "itemList": [
        {
          "type": "squareCardCollection",
          "data": {
            "dataType": "ItemCollection",
            "header": {
              "id": 1,
              "title": "热门分类",
              "font": "bold",
              "cover": null,
              "label": null,
              "actionUrl": "eyepetizer://categories/all"
            },
            "itemList": [
              {
                "type": "squareCard",
                "data": {
                  "dataType": "SquareCard",
                  "id": 22,
                  "title": "#记录",
                  "image": "http://img.kaiyanapp.com/a2fc6d32ac0b4f2842fb3d545d06f09b.jpeg",
                  "actionUrl": "eyepetizer://category/22/?title=%E8%AE%B0%E5%BD%95",
                  "shade": true,
                  "adTrack": null
                }
              }
            ],
            "count": 1,
            "adTrack": null
          }
        },
        {
          "type": "bannerCollection",
          "data": {
            "dataType": "ItemCollection",
            "header": {
              "id": 4,
              "title": "热门专题",
              "font": "bold",
              "cover": null,
              "label": null,
              "actionUrl": "eyepetizer://campaign/list/?title=%E4%B8%93%E9%A2%98"
            },
            "itemList": [
              {
                "type": "banner2",
                "data": {
                  "dataType": "Banner",
                  "id": 130,
                  "title": "",
                  "description": "",
                  "image": "http://img.kaiyanapp.com/a366c422fe5765e8fd41ac542ff2607b.jpeg?imageMogr2/quality/60/format/jpg",
                  "actionUrl": "eyepetizer://webview/?title=%E4%BB%8A%E5%A4%9C%E6%97%A0%E4%BA%BA%E5%85%A5%E7%9D%A1%EF%BC%8C%E5%A4%B1%E7%9C%A0%E8%BF%9B%E8%A1%8C%E6%97%B6&url=http%3A%2F%2Fwww.eyepetizer.net%2Fvideos_article.html%3Fnid%3D130%26shareable%3Dtrue",
                  "adTrack": null,
                  "shade": false,
                  "label": {
                    "text": null,
                    "card": null,
                    "detail": null
                  }
                }
              }
            ],
            "count": 1,
            "adTrack": null
          }
        },
        {
          "type": "videoCollectionOfHorizontalScrollCard",
          "data": {
            "dataType": "ItemCollection",
            "header": {
              "id": 22,
              "title": "记录",
              "font": "normal",
              "cover": null,
              "label": null,
              "actionUrl": "eyepetizer://category/22/?title=%E8%AE%B0%E5%BD%95",
              "subTitle": "告诉他们为什么与众不同",
              "follow": {
                "itemType": "category",
                "itemId": 22,
                "followed": false
              }
            },
            "itemList": [
              {
                "type": "video",
                "data": {
                  "dataType": "VideoBeanForClient",
                  "id": 15048,
                  "title": "有一种疼痛会让人上瘾",
                  "description": "《犀利哟》#玩的辣#。人都怕疼痛，但有一种疼痛会让人上瘾，那就是纹身，每一个纹身都有自己的故事，有美好的故事，有痛苦的故事，但纹身过程中的疼痛会让你对某件事刻骨铭心，脱离疼痛的纹身是不完整的",
                  "provider": {
                    "name": "PGC",
                    "alias": "PGC",
                    "icon": ""
                  },
                  "category": "记录",
                  "author": {
                    "id": 317,
                    "icon": "http://img.kaiyanapp.com/55224f20773a5f84356f1bb94fdf3fc9.jpeg?imageMogr2/quality/60/format/jpg",
                    "name": "犀利哟",
                    "description": "青年文化视频杂志 ",
                    "link": "",
                    "latestReleaseTime": 1488362280000,
                    "videoNum": 8,
                    "adTrack": null,
                    "follow": {
                      "itemType": "author",
                      "itemId": 317,
                      "followed": false
                    },
                    "authorType": "NORMAL"
                  },
                  "cover": {
                    "feed": "http://img.kaiyanapp.com/e5609d5111605d5b98d6227ca67bdafe.png?imageMogr2/quality/60/format/jpg",
                    "detail": "http://img.kaiyanapp.com/e5609d5111605d5b98d6227ca67bdafe.png?imageMogr2/quality/60/format/jpg",
                    "blurred": "http://img.kaiyanapp.com/9cc6e0e9924f2705acb1fc8607443b52.jpeg?imageMogr2/quality/60/format/jpg",
                    "sharing": null
                  },
                  "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15048&editionType=default&source=ucloud",
                  "duration": 283,
                  "webUrl": {
                    "raw": "http://www.eyepetizer.net/detail.html?vid=15048",
                    "forWeibo": "http://wandou.im/3m70tb"
                  },
                  "releaseTime": 1488362280000,
                  "playInfo": [
                    {
                      "height": 480,
                      "width": 854,
                      "urlList": [
                        {
                          "name": "ucloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15048&editionType=normal&source=ucloud"
                        },
                        {
                          "name": "qcloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15048&editionType=normal&source=qcloud"
                        }
                      ],
                      "name": "标清",
                      "type": "normal",
                      "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15048&editionType=normal&source=ucloud"
                    },
                    {
                      "height": 720,
                      "width": 1280,
                      "urlList": [
                        {
                          "name": "ucloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15048&editionType=high&source=ucloud"
                        },
                        {
                          "name": "qcloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15048&editionType=high&source=qcloud"
                        }
                      ],
                      "name": "高清",
                      "type": "high",
                      "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15048&editionType=high&source=ucloud"
                    }
                  ],
                  "consumption": {
                    "collectionCount": 9,
                    "shareCount": 16,
                    "replyCount": 0
                  },
                  "campaign": null,
                  "waterMarks": null,
                  "adTrack": null,
                  "tags": [],
                  "type": "NORMAL",
                  "idx": 0,
                  "shareAdTrack": null,
                  "favoriteAdTrack": null,
                  "webAdTrack": null,
                  "date": 1488362280000,
                  "promotion": null,
                  "label": null,
                  "collected": false,
                  "played": false
                }
              }
            ],
            "count": 1,
            "adTrack": null
          }
        }
      ],
      "count": 3,
      "total": 0,
      "nextPageUrl": "http://baobab.kaiyanapp.com/api/v4/discovery/category?start=4&num=4"
    }

json 解析：
除了新增的几个类型之外，其他类型和[首页](#home)中的相同

<h4 id="category_squareCardCollection">squareCardCollection</h4>

- `type`：固定值 `squareCardCollection`
- `data`
	- `dataType`：固定值 `ItemCollection`
	- `count`：`itemList` 长度
	- `itemList`：数据列表
		- `data`
			- `id`：id
			- `title`：标题信息
			- `image`：图片信息
			- `description`：简易描述
			- `actionUrl`：拼接 url

<h4 id="category_bannerCollection">bannerCollection</h4>

- `type`：固定值 `bannerCollection`
- `data`
	- `dataType`：固定值 `ItemCollection`
	- `count`：`itemList` 长度
	- `itemList`：数据列表
		- `data`
			- `id`：id
			- `title`：标题信息
			- `image`：图片信息
			- `description`：简易描述
			- `actionUrl`：拼接 url

<h4 id="category_videoCollectionOfHorizontalScrollCard">videoCollectionOfHorizontalScrollCard</h4>

- `type`：固定值 `videoCollectionOfHorizontalScrollCard`
- `data`
	- `dataType`：固定值 `ItemCollection`
	- `count`：`itemList` 长度
	- `itemList`：数据列表
		- `data`
			- `id`：id
			- `title`：标题信息
			- `follow`
			- `subTitle`：
			- `image`：图片信息
			- `description`：简易描述
			- `actionUrl`：拼接 url

<h3 id="author">作者</h3>

url 从[获取分类](#title)中获取

json 示例：

	{
      "itemList": [
        {
          "type": "leftAlignTextHeader",
          "data": {
            "dataType": "LeftAlignTextHeader",
            "text": "热门作者",
            "font": "normal",
            "actionUrl": null,
            "adTrack": null
          }
        },
        {
          "type": "briefCard",
          "data": {
            "dataType": "BriefCard",
            "id": 272,
            "icon": "http://img.kaiyanapp.com/c1f2823be22426d692fb025d16c0b9ff.jpeg?imageMogr2/quality/60",
            "iconType": "round",
            "title": "箭厂",
            "subTitle": null,
            "description": "世界超乎想象，故事正在发生。",
            "actionUrl": "eyepetizer://pgc/detail/272/?title=%E7%AE%AD%E5%8E%82",
            "adTrack": null,
            "follow": {
              "itemType": "author",
              "itemId": 272,
              "followed": false
            }
          }
        },
        {
          "type": "blankCard",
          "data": {
            "dataType": "BlankCard",
            "height": 15
          }
        },
        {
          "type": "videoCollectionWithBrief",
          "data": {
            "dataType": "ItemCollection",
            "header": {
              "id": 330,
              "icon": "http://img.kaiyanapp.com/a77788d2c4a7e823e87ffb3685697ba8.jpeg?imageMogr2/quality/60",
              "iconType": "round",
              "title": "微软 XBOX",
              "subTitle": null,
              "description": "微软 XBOX 最新游戏视频与资讯",
              "actionUrl": "eyepetizer://pgc/detail/330/?title=%E5%BE%AE%E8%BD%AF%20XBOX",
              "adTrack": null,
              "follow": {
                "itemType": "author",
                "itemId": 330,
                "followed": false
              }
            },
            "itemList": [
              {
                "type": "video",
                "data": {
                  "dataType": "VideoBeanForClient",
                  "id": 9616,
                  "title": "Ken Block 的 GYMKHANA NINE 赛道",
                  "description": "Hoonigan 和「极限竞速3」一起，骄傲地发布  Ken Block 的Gymkhana NINE 赛道。",
                  "provider": {
                    "name": "定制来源",
                    "alias": "CustomSrc",
                    "icon": ""
                  },
                  "category": "游戏",
                  "author": {
                    "id": 330,
                    "icon": "http://img.kaiyanapp.com/a77788d2c4a7e823e87ffb3685697ba8.jpeg?imageMogr2/quality/60",
                    "name": "微软 XBOX",
                    "description": "微软 XBOX 最新游戏视频与资讯",
                    "link": "",
                    "latestReleaseTime": 1488367300000,
                    "videoNum": 12,
                    "adTrack": null,
                    "follow": {
                      "itemType": "author",
                      "itemId": 330,
                      "followed": false
                    },
                    "authorType": "MOCK"
                  },
                  "cover": {
                    "feed": "http://img.kaiyanapp.com/e3fd8a154f1f0d36f1a14b42b07fd0c1.jpeg?imageMogr2/quality/60/format/jpg",
                    "detail": "http://img.kaiyanapp.com/e3fd8a154f1f0d36f1a14b42b07fd0c1.jpeg?imageMogr2/quality/60/format/jpg",
                    "blurred": "http://img.kaiyanapp.com/fcef36c7773f10340511000f0a5d645f.jpeg?imageMogr2/quality/60/format/jpg",
                    "sharing": null
                  },
                  "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=default&source=ucloud",
                  "duration": 491,
                  "webUrl": {
                    "raw": "http://www.eyepetizer.net/detail.html?vid=9616",
                    "forWeibo": "http://www.wandoujia.com/eyepetizer/detail.html?vid=9616"
                  },
                  "releaseTime": 1488367300000,
                  "playInfo": [
                    {
                      "height": 480,
                      "width": 854,
                      "urlList": [
                        {
                          "name": "ucloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=normal&source=ucloud"
                        },
                        {
                          "name": "qcloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=normal&source=qcloud"
                        }
                      ],
                      "name": "标清",
                      "type": "normal",
                      "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=normal&source=ucloud"
                    },
                    {
                      "height": 720,
                      "width": 1280,
                      "urlList": [
                        {
                          "name": "ucloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=high&source=ucloud"
                        },
                        {
                          "name": "qcloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=high&source=qcloud"
                        }
                      ],
                      "name": "高清",
                      "type": "high",
                      "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9616&editionType=high&source=ucloud"
                    }
                  ],
                  "consumption": {
                    "collectionCount": 1579,
                    "shareCount": 3212,
                    "replyCount": 64
                  },
                  "campaign": null,
                  "waterMarks": null,
                  "adTrack": null,
                  "tags": [
                    {
                      "id": 4,
                      "name": "运动",
                      "actionUrl": "eyepetizer://tag/4/?title=%E8%BF%90%E5%8A%A8",
                      "adTrack": null
                    },
                    {
                      "id": 296,
                      "name": "赛车",
                      "actionUrl": "eyepetizer://tag/296/?title=%E8%B5%9B%E8%BD%A6",
                      "adTrack": null
                    },
                    {
                      "id": 314,
                      "name": "漂移",
                      "actionUrl": "eyepetizer://tag/314/?title=%E6%BC%82%E7%A7%BB",
                      "adTrack": null
                    }
                  ],
                  "type": "NORMAL",
                  "idx": 0,
                  "shareAdTrack": null,
                  "favoriteAdTrack": null,
                  "webAdTrack": null,
                  "date": 1488367300000,
                  "promotion": null,
                  "label": null,
                  "collected": false,
                  "played": false
                }
              }
            ],
            "count": 5,
            "adTrack": null
          }
        }
      ],
      "count": 4,
      "total": 0,
      "nextPageUrl": "http://baobab.kaiyanapp.com/api/v4/pgcs/all?start=10&num=10"
    }

json 解析：
除了新增的几个类型之外，其他类型和[首页](#home)中的相同

<h4 id="author_leftAlignTextHeader">leftAlignTextHeader</h4>

- `type`：固定值 `leftAlignTextHeader`
- `data`
	- `dataType`：固定值 `LeftAlignTextHeader`
	- `text`：内容
	- `font`：字体
	- `actionUrl`：需要拼接的 url

<h4 id="author_blankCard">blankCard</h4>

- `type`：固定值 `blankCard`
- `data`
	- `dataType`：固定值 `blankCard`
	- `height`：方块宽高

<h4 id="author_videoCollectionWithBrief">videoCollectionWithBrief</h4>

- `type`：固定值 `videoCollectionWithBrief`
- `data`
	- `dataType`：固定值 `ItemCollection`
	- `count`：`itemList` 长度
	- `itemList`：数据列表
		- `data`
			- `id`：id
			- `title`：标题信息
			- `image`：图片信息
			- `description`：简易描述
			- `actionUrl`：拼接 url

<h4 id="author_briefCard">briefCard</h4>

- `type`：固定值 `briefCard`
- `data`
	- `dataType`：固定值 `BriefCard`
	- `count`：`itemList` 长度
	- `itemList`：数据列表
		- `data`
			- `id`：id
			- `title`：标题信息
			- `icon`：图片信息
			- `description`：简易描述
			- `actionUrl`：拼接 url

<h2 id="follow">关注</h2>

url：[`http://baobab.kaiyanapp.com/api/v4/tabs/follow`](http://baobab.kaiyanapp.com/api/v4/tabs/follow)

拼接参数：

- `udid`：用户唯一标识。该参数可为空也可去除
- `vc`：???，固定值`168`。该参数可为空也可去除
- `vn`：客户端版本。该参数可为空也可去除
- `deviceModel`：手机信息。该参数可为空也可去除
- `first_channel`：???，固定值 `eyepetizer_baidu_market`。该参数可为空也可去除
- `last_channel`：???，固定值 `eyepetizer_baidu_market`。该参数可为空也可去除
- `system_version_code`：手机系统版本。该参数可为空也可去除

url 示例：[`http://baobab.kaiyanapp.com/api/v4/tabs/follow?udid=11111&vc=168&vn=3.3.1&deviceModel=Huawei%36&first_channel=eyepetizer_baidu_market&last_channel=eyepetizer_baidu_market&system_version_code=20`](http://baobab.kaiyanapp.com/api/v4/tabs/follow?udid=11111&vc=168&vn=3.3.1&deviceModel=Huawei%36&first_channel=eyepetizer_baidu_market&last_channel=eyepetizer_baidu_market&system_version_code=20) 或 [`http://baobab.kaiyanapp.com/api/v4/tabs/follow`](http://baobab.kaiyanapp.com/api/v4/tabs/follow)

json 示例：

	{
      "itemList": [
        {
          "type": "videoCollectionWithBrief",
          "data": {
            "dataType": "ItemCollection",
            "header": {
              "id": 174,
              "icon": "http://img.kaiyanapp.com/ddc5c8162f82415c44d88395bdb86a2b.jpeg",
              "iconType": "round",
              "title": "美食台",
              "subTitle": null,
              "description": "饿了记得来找我们！",
              "actionUrl": "eyepetizer://pgc/detail/174/?title=%E7%BE%8E%E9%A3%9F%E5%8F%B0",
              "adTrack": null,
              "follow": {
                "itemType": "author",
                "itemId": 174,
                "followed": false
              }
            },
            "itemList": [
              {
                "type": "video",
                "data": {
                  "dataType": "VideoBeanForClient",
                  "id": 15049,
                  "title": "饼干原来是这样做的！简单！",
                  "description": "饼干是零基础的烘焙小点之一，制作简单，松脆可口。今天，我们教你做三角形的芝士口味饼干，你也可以切分成自己喜欢的形状，无辣不欢的朋友还可以在揉面时加入一些辣椒粉。",
                  "provider": {
                    "name": "PGC",
                    "alias": "PGC",
                    "icon": ""
                  },
                  "category": "开胃",
                  "author": {
                    "id": 174,
                    "icon": "http://img.kaiyanapp.com/ddc5c8162f82415c44d88395bdb86a2b.jpeg",
                    "name": "美食台",
                    "description": "饿了记得来找我们！",
                    "link": "",
                    "latestReleaseTime": 1488362362000,
                    "videoNum": 131,
                    "adTrack": null,
                    "follow": {
                      "itemType": "author",
                      "itemId": 174,
                      "followed": false
                    },
                    "authorType": "NORMAL"
                  },
                  "cover": {
                    "feed": "http://img.kaiyanapp.com/caafa68b6bbd6dce68bf0bfdeac8bf11.png?imageMogr2/quality/60/format/jpg",
                    "detail": "http://img.kaiyanapp.com/caafa68b6bbd6dce68bf0bfdeac8bf11.png?imageMogr2/quality/60/format/jpg",
                    "blurred": "http://img.kaiyanapp.com/86f754ef9cb10714ea4c5ec8a15ec338.jpeg?imageMogr2/quality/60/format/jpg",
                    "sharing": null
                  },
                  "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15049&editionType=default&source=ucloud",
                  "duration": 182,
                  "webUrl": {
                    "raw": "http://www.eyepetizer.net/detail.html?vid=15049",
                    "forWeibo": "http://wandou.im/3m70tr"
                  },
                  "releaseTime": 1488362362000,
                  "playInfo": [
                    {
                      "height": 480,
                      "width": 854,
                      "urlList": [
                        {
                          "name": "ucloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15049&editionType=normal&source=ucloud"
                        },
                        {
                          "name": "qcloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15049&editionType=normal&source=qcloud"
                        }
                      ],
                      "name": "标清",
                      "type": "normal",
                      "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15049&editionType=normal&source=ucloud"
                    },
                    {
                      "height": 720,
                      "width": 1280,
                      "urlList": [
                        {
                          "name": "ucloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15049&editionType=high&source=ucloud"
                        },
                        {
                          "name": "qcloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15049&editionType=high&source=qcloud"
                        }
                      ],
                      "name": "高清",
                      "type": "high",
                      "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15049&editionType=high&source=ucloud"
                    }
                  ],
                  "consumption": {
                    "collectionCount": 123,
                    "shareCount": 22,
                    "replyCount": 0
                  },
                  "campaign": null,
                  "waterMarks": null,
                  "adTrack": null,
                  "tags": [],
                  "type": "NORMAL",
                  "idx": 0,
                  "shareAdTrack": null,
                  "favoriteAdTrack": null,
                  "webAdTrack": null,
                  "date": 1488362362000,
                  "promotion": null,
                  "label": null,
                  "collected": false,
                  "played": false
                }
              }
            ],
            "count": 5,
            "adTrack": null
          }
        },
        {
          "type": "videoCollectionOfHorizontalScrollCard",
          "data": {
            "dataType": "ItemCollection",
            "header": {
              "id": 38,
              "title": "综艺",
              "font": "normal",
              "cover": null,
              "label": null,
              "actionUrl": "eyepetizer://category/38/?title=%E7%BB%BC%E8%89%BA",
              "subTitle": "全球网红在表演什么",
              "follow": {
                "itemType": "category",
                "itemId": 38,
                "followed": false
              }
            },
            "itemList": [
              {
                "type": "video",
                "data": {
                  "dataType": "VideoBeanForClient",
                  "id": 10258,
                  "title": "重口慎点：百年丧尸进化",
                  "description": "丧尸最初和僵尸区分不大，都带有哥特感，皮肤灰败有的甚至会带有吸血鬼属性。然而从丧尸造型变化我们可以看到，观众和游戏玩家已经越来越重口，人们需要不断的刺激。From Xbox",
                  "provider": {
                    "name": "YouTube",
                    "alias": "youtube",
                    "icon": "http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"
                  },
                  "category": "综艺",
                  "author": null,
                  "cover": {
                    "feed": "http://img.kaiyanapp.com/6f2241c9ceba2779866293ee5843a902.jpeg?imageMogr2/quality/60",
                    "detail": "http://img.kaiyanapp.com/6f2241c9ceba2779866293ee5843a902.jpeg?imageMogr2/quality/60",
                    "blurred": "http://img.kaiyanapp.com/e9d8bb8dc1119e97445ec376ad4e2308.jpeg?imageMogr2/quality/60",
                    "sharing": null
                  },
                  "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=10258&editionType=default&source=ucloud",
                  "duration": 162,
                  "webUrl": {
                    "raw": "http://www.eyepetizer.net/detail.html?vid=10258",
                    "forWeibo": "http://wandou.im/35y8sf"
                  },
                  "releaseTime": 1477843200000,
                  "playInfo": [
                    {
                      "height": 480,
                      "width": 854,
                      "urlList": [
                        {
                          "name": "ucloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=10258&editionType=normal&source=ucloud"
                        },
                        {
                          "name": "qcloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=10258&editionType=normal&source=qcloud"
                        }
                      ],
                      "name": "标清",
                      "type": "normal",
                      "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=10258&editionType=normal&source=ucloud"
                    },
                    {
                      "height": 720,
                      "width": 1280,
                      "urlList": [
                        {
                          "name": "ucloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=10258&editionType=high&source=ucloud"
                        },
                        {
                          "name": "qcloud",
                          "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=10258&editionType=high&source=qcloud"
                        }
                      ],
                      "name": "高清",
                      "type": "high",
                      "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=10258&editionType=high&source=ucloud"
                    }
                  ],
                  "consumption": {
                    "collectionCount": 1204,
                    "shareCount": 2400,
                    "replyCount": 56
                  },
                  "campaign": null,
                  "waterMarks": null,
                  "adTrack": null,
                  "tags": [
                    {
                      "id": 28,
                      "name": "综艺",
                      "actionUrl": "eyepetizer://tag/28/?title=%E7%BB%BC%E8%89%BA",
                      "adTrack": null
                    },
                    {
                      "id": 484,
                      "name": "干货",
                      "actionUrl": "eyepetizer://tag/484/?title=%E5%B9%B2%E8%B4%A7",
                      "adTrack": null
                    },
                    {
                      "id": 572,
                      "name": "历史",
                      "actionUrl": "eyepetizer://tag/572/?title=%E5%8E%86%E5%8F%B2",
                      "adTrack": null
                    },
                    {
                      "id": 132,
                      "name": "恐怖",
                      "actionUrl": "eyepetizer://tag/132/?title=%E6%81%90%E6%80%96",
                      "adTrack": null
                    }
                  ],
                  "type": "NORMAL",
                  "idx": 0,
                  "shareAdTrack": null,
                  "favoriteAdTrack": null,
                  "webAdTrack": null,
                  "date": 1477843200000,
                  "promotion": null,
                  "label": null,
                  "collected": false,
                  "played": false
                }
              }
            ],
            "count": 1,
            "adTrack": null
          }
        }
      ],
      "count": 2,
      "total": 0,
      "nextPageUrl": "http://baobab.kaiyanapp.com/api/v4/tabs/follow?start=2&num=2&follow=false&startId=0",
      "updateTime": null
    }

json 解析：
<h3 id="follow_videoCollectionWithBrief">videoCollectionWithBrief</h3>
与前面的相同

<h3 id="follow_videoCollectionOfHorizontalScrollCard">videoCollectionOfHorizontalScrollCard</h3>
与前面的相同