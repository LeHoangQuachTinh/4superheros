//
//  Picker.swift
//  Study
//
//  Created by Tỉnh  on 30/09/2024.
//

import SwiftUI

struct Picker1: View {
    @State var selectOptions:Int = 1
    let filterOptions:[String]=[
    "Le","Hoang","Quach","Tinh"
    ]
    init() {
        UISegmentedControl.appearance().selectedSegmentTintColor = UIColor.blue
        
        let attributes:[NSAttributedString.Key:Any] = [
            .foregroundColor :UIColor.white
        ]
        UISegmentedControl.appearance().setTitleTextAttributes(attributes, for: .selected)
        
        //chỉ có thể dùng UIkit mới có thể đổi màu được SegmentPicker
    }
    var body: some View {
        
        Picker(
            selection: $selectOptions,
            label:Text("Picker"),
            content:{
                ForEach(filterOptions.indices,id: \.self){index in
                    Text("\(filterOptions[index])")
                        .tag(index)
                }
            })
                .pickerStyle(SegmentedPickerStyle())
//                .pickerStyle(MenuPickerStyle())
//                .pickerStyle(WheelPickerStyle())
        
        
    }
}

#Preview {
    Picker1()
}
