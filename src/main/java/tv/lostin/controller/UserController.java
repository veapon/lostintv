package tv.lostin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tv.lostin.response.MenuItemVo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description
 *
 * @author veapon
 * @date 2022/8/22
 */
@RestController
@RequestMapping("/Users")
public class UserController {

    @GetMapping("/Public")
    public HashMap<String, Object>  publicInfo() {
        return new HashMap<>();
    }

    @PostMapping("/AuthenticateByName")
    public HashMap authenticateByName() throws JsonProcessingException {
        String json = "{\"User\":{\"Name\":\"root\",\"ServerId\":\"17b4441a87d04649a83e31deae5bf692\",\"Id\":\"438beee12c5e40fea92c4d0c658e27f9\",\"HasPassword\":true,\"HasConfiguredPassword\":true,\"HasConfiguredEasyPassword\":false,\"EnableAutoLogin\":false,\"LastLoginDate\":\"2022-08-22T10:06:35.8398452Z\",\"LastActivityDate\":\"2022-08-22T10:06:35.8398452Z\",\"Configuration\":{\"PlayDefaultAudioTrack\":true,\"SubtitleLanguagePreference\":\"\",\"DisplayMissingEpisodes\":false,\"GroupedFolders\":[],\"SubtitleMode\":\"Default\",\"DisplayCollectionsView\":false,\"EnableLocalPassword\":false,\"OrderedViews\":[],\"LatestItemsExcludes\":[],\"MyMediaExcludes\":[],\"HidePlayedInLatest\":true,\"RememberAudioSelections\":true,\"RememberSubtitleSelections\":true,\"EnableNextEpisodeAutoPlay\":true},\"Policy\":{\"IsAdministrator\":true,\"IsHidden\":true,\"IsDisabled\":false,\"BlockedTags\":[],\"EnableUserPreferenceAccess\":true,\"AccessSchedules\":[],\"BlockUnratedItems\":[],\"EnableRemoteControlOfOtherUsers\":true,\"EnableSharedDeviceControl\":true,\"EnableRemoteAccess\":true,\"EnableLiveTvManagement\":true,\"EnableLiveTvAccess\":true,\"EnableMediaPlayback\":true,\"EnableAudioPlaybackTranscoding\":true,\"EnableVideoPlaybackTranscoding\":true,\"EnablePlaybackRemuxing\":true,\"ForceRemoteSourceTranscoding\":false,\"EnableContentDeletion\":true,\"EnableContentDeletionFromFolders\":[],\"EnableContentDownloading\":true,\"EnableSyncTranscoding\":true,\"EnableMediaConversion\":true,\"EnabledDevices\":[],\"EnableAllDevices\":true,\"EnabledChannels\":[],\"EnableAllChannels\":true,\"EnabledFolders\":[],\"EnableAllFolders\":true,\"InvalidLoginAttemptCount\":0,\"LoginAttemptsBeforeLockout\":-1,\"MaxActiveSessions\":0,\"EnablePublicSharing\":true,\"BlockedMediaFolders\":[],\"BlockedChannels\":[],\"RemoteClientBitrateLimit\":0,\"AuthenticationProviderId\":\"Jellyfin.Server.Implementations.Users.DefaultAuthenticationProvider\",\"PasswordResetProviderId\":\"Jellyfin.Server.Implementations.Users.DefaultPasswordResetProvider\",\"SyncPlayAccess\":\"CreateAndJoinGroups\"}},\"SessionInfo\":{\"PlayState\":{\"CanSeek\":false,\"IsPaused\":false,\"IsMuted\":false,\"RepeatMode\":\"RepeatNone\"},\"AdditionalUsers\":[],\"Capabilities\":{\"PlayableMediaTypes\":[],\"SupportedCommands\":[],\"SupportsMediaControl\":false,\"SupportsContentUploading\":false,\"SupportsPersistentIdentifier\":true,\"SupportsSync\":false},\"RemoteEndPoint\":\"172.18.0.1\",\"PlayableMediaTypes\":[],\"Id\":\"fadf8066872d79cdf1f5533695f1a6d5\",\"UserId\":\"438beee12c5e40fea92c4d0c658e27f9\",\"UserName\":\"root\",\"Client\":\"Jellyfin Web (Vue)\",\"LastActivityDate\":\"2022-08-22T10:06:35.8801025Z\",\"LastPlaybackCheckIn\":\"0001-01-01T00:00:00.0000000Z\",\"DeviceName\":\"Chrome\",\"DeviceId\":\"27d7a7f2-7abc-4fdc-8435-0b461c796a37\",\"ApplicationVersion\":\"0.0.0\",\"IsActive\":true,\"SupportsMediaControl\":false,\"SupportsRemoteControl\":false,\"NowPlayingQueue\":[],\"NowPlayingQueueFullItems\":[],\"HasCustomDeviceName\":false,\"ServerId\":\"17b4441a87d04649a83e31deae5bf692\",\"SupportedCommands\":[]},\"AccessToken\":\"069c654bd7844b67b9c33e6661c84fd4\",\"ServerId\":\"17b4441a87d04649a83e31deae5bf692\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, HashMap.class);
    }

    @GetMapping("/{userId}/Items/Latest")
    public ArrayList latestItems() {
        return new ArrayList();
    }

    @GetMapping("/{userId}/Views")
    public HashMap<String, Object> views() throws JsonProcessingException {
//        HashMap<String, Object> menu = new HashMap<>();
//
//        MenuItemVo menuItem = new MenuItemVo();
//        menuItem.setId("7e64e319657a9516ec78490da03edccb");
//        menuItem.setName("Music");
//        menuItem.setPath("/Music");
//        menuItem.setLocationType("FileSystem");
//        menuItem.setType("CollectionFolder");
//        menuItem.setServerId("7e64e319657a9516ec78490da03edccb");
//        menuItem.setCollectionType("music");
//        menuItem.setIsFolder(true);
//        menuItem.setEnableMediaSourceDisplay(true);
//
//        ArrayList<MenuItemVo> items = new ArrayList<>();
//        items.add(menuItem);
//        menu.put("Items", items);
//        menu.put("TotalRecordCount", items.stream().count());
//        menu.put("StartIndex", 0);
//
//        return menu;
        String json = "{\n" +
                "    \"Items\":[\n" +
                "        {\n" +
                "            \"Name\":\"Music\",\n" +
                "            \"ServerId\":\"17b4441a87d04649a83e31deae5bf692\",\n" +
                "            \"Id\":\"7e64e319657a9516ec78490da03edccb\",\n" +
                "            \"Etag\":\"69497bccc95f8722ff59ead380a75120\",\n" +
                "            \"DateCreated\":\"2022-06-06T10:44:42.5210399Z\",\n" +
                "            \"CanDelete\":false,\n" +
                "            \"CanDownload\":false,\n" +
                "            \"SortName\":\"music\",\n" +
                "            \"ExternalUrls\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"Path\":\"/config/root/default/Music\",\n" +
                "            \"EnableMediaSourceDisplay\":true,\n" +
                "            \"ChannelId\":null,\n" +
                "            \"Taglines\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"Genres\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"PlayAccess\":\"Full\",\n" +
                "            \"RemoteTrailers\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"ProviderIds\":{\n" +
                "\n" +
                "            },\n" +
                "            \"IsFolder\":true,\n" +
                "            \"ParentId\":\"e9d5075a555c1cbc394eec4cef295274\",\n" +
                "            \"Type\":\"CollectionFolder\",\n" +
                "            \"People\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"Studios\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"GenreItems\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"LocalTrailerCount\":0,\n" +
                "            \"UserData\":{\n" +
                "                \"PlaybackPositionTicks\":0,\n" +
                "                \"PlayCount\":0,\n" +
                "                \"IsFavorite\":false,\n" +
                "                \"Played\":false,\n" +
                "                \"Key\":\"7e64e319-657a-9516-ec78-490da03edccb\"\n" +
                "            },\n" +
                "            \"ChildCount\":7,\n" +
                "            \"SpecialFeatureCount\":0,\n" +
                "            \"DisplayPreferencesId\":\"7e64e319657a9516ec78490da03edccb\",\n" +
                "            \"Tags\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"PrimaryImageAspectRatio\":1.7777777777777777,\n" +
                "            \"CollectionType\":\"music\",\n" +
                "            \"ImageTags\":{\n" +
                "                \"Primary\":\"a241ed684564afc368839462b6a3a58a\"\n" +
                "            },\n" +
                "            \"BackdropImageTags\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"ImageBlurHashes\":{\n" +
                "                \"Primary\":{\n" +
                "                    \"a241ed684564afc368839462b6a3a58a\":\"W68z#~xu00Rj-;%M?HWBIUM{aybGMxj[_3ofIUt7ayofxaofofof\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"LocationType\":\"FileSystem\",\n" +
                "            \"LockedFields\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"LockData\":false\n" +
                "        },\n" +
                "        {\n" +
                "            \"Name\":\"Playlists\",\n" +
                "            \"ServerId\":\"17b4441a87d04649a83e31deae5bf692\",\n" +
                "            \"Id\":\"686d6a16e5e772d0529d56fd2f8ad3b2\",\n" +
                "            \"Etag\":\"5c11e625fdf177de0fdd16e607d4e32f\",\n" +
                "            \"DateCreated\":\"2022-06-24T04:33:45.9623085Z\",\n" +
                "            \"CanDelete\":false,\n" +
                "            \"CanDownload\":false,\n" +
                "            \"SortName\":\"playlists\",\n" +
                "            \"ExternalUrls\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"Path\":\"/config/metadata/views/686d6a16e5e772d0529d56fd2f8ad3b2\",\n" +
                "            \"EnableMediaSourceDisplay\":true,\n" +
                "            \"ChannelId\":null,\n" +
                "            \"Taglines\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"Genres\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"PlayAccess\":\"Full\",\n" +
                "            \"RemoteTrailers\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"ProviderIds\":{\n" +
                "\n" +
                "            },\n" +
                "            \"IsFolder\":true,\n" +
                "            \"ParentId\":null,\n" +
                "            \"Type\":\"UserView\",\n" +
                "            \"People\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"Studios\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"GenreItems\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"LocalTrailerCount\":0,\n" +
                "            \"UserData\":{\n" +
                "                \"PlaybackPositionTicks\":0,\n" +
                "                \"PlayCount\":0,\n" +
                "                \"IsFavorite\":false,\n" +
                "                \"Played\":false,\n" +
                "                \"Key\":\"686d6a16-e5e7-72d0-529d-56fd2f8ad3b2\"\n" +
                "            },\n" +
                "            \"ChildCount\":1,\n" +
                "            \"SpecialFeatureCount\":0,\n" +
                "            \"DisplayPreferencesId\":\"cb46bc72e78d95cc6cd072de3a65b93a\",\n" +
                "            \"Tags\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"PrimaryImageAspectRatio\":1.7777777777777777,\n" +
                "            \"CollectionType\":\"playlists\",\n" +
                "            \"ImageTags\":{\n" +
                "                \"Primary\":\"16fdf47146d37f81852d8f97d606ce9e\"\n" +
                "            },\n" +
                "            \"BackdropImageTags\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"ImageBlurHashes\":{\n" +
                "                \"Primary\":{\n" +
                "                    \"16fdf47146d37f81852d8f97d606ce9e\":\"WE8gy-ofD%ayM{j[t7j[ayayWBj[00ay-;j[t7ofRjayofofofj[\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"LocationType\":\"FileSystem\",\n" +
                "            \"LockedFields\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"LockData\":false\n" +
                "        }\n" +
                "    ],\n" +
                "    \"TotalRecordCount\":2,\n" +
                "    \"StartIndex\":0\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, HashMap.class);
    }
}
