import { View, Image, Text } from "react-native";
import React from "react";
import SwiperFlatList from "react-native-swiper-flatlist";
import { useFonts } from "expo-font";

const Homepage = () => {
  const swiperData = [
    {
      id: 1,
      img: require("../../assets/green1.png"),
      color: "#8B3C11",
      icon: require("../../assets/mountains.png"),
      text: "Climb the Mountains",
    },
    {
      id: 2,
      img: require("../../assets/desert1.png"),
      color: "#77ADCF",
      icon: require("../../assets/desert.png"),
      text: "Starve the Desers",
    },
    {
      id: 3,
      img: require("../../assets/sea1.png"),
      color: "#0061B8",
      icon: require("../../assets/boat.png"),
      text: "Feel the See",
    },
  ];

  return (
    <View>
      <SwiperFlatList
        autoplay={true}
        autoplayDelay={2}
        autoplayLoop={true}
        showPagination
        paginationStyleItem={{ marginTop: 30 }}
        paginationStyleItemActive={{
          backgroundColor: "#C7D3E1",
        }}
      >
        {swiperData.map((data, id) => {
          return <SwiperSlide data={data} />;
        })}
      </SwiperFlatList>
    </View>
  );
};

const SwiperSlide = (props) => {
  const [fontLoaded] = useFonts({
    BabeN: require("../../assets/font/BebasNeue-Regular.ttf"),
  });
  const dataa = props.data;
  return (
    <View style={{ marginHorizontal: 30 }}>
      <Image
        style={{
          height: 200,
          borderRadius: 10,
          width: 350,
        }}
        source={dataa.img}
      />
      <View
        style={{
          flexDirection: "row",
          alignItems: "center",
          justifyContent: "center",
        }}
      >
        <Image
          style={{ height: 30, width: 30, marginRight: 10 }}
          source={dataa.icon}
        />
        <Text
          style={{
            fontFamily: "BabeN",
            fontSize: 19,
            color: dataa.color,
            textAlign: "center",
            marginTop: 10,
          }}
        >
          {dataa.text}
        </Text>
      </View>
    </View>
  );
};
export default Homepage;
