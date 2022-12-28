import React from "react";
import Card from "./Card";

function ProfileCard(props){
    return (
        <Card title="손흥민" backgroundColor={'yellow'}>
            <p>안녕하세요</p>
            <p>저는 축구를 합니다</p>
        </Card>
    )

}

export default ProfileCard