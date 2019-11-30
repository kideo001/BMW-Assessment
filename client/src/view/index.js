import React, { useState, useEffect } from 'react';
import { Table } from 'antd'
import MODEL from './model'
import 'antd/dist/antd.css'

export function View() {
    const [isLoading, setLoading] = useState(true);
    const [data, setData] = useState([]);
    const [inError, setError] = useState(false);
    const [filters, setFilters] = useState([]);

    useEffect(() => {
        MODEL.getData().then((res) => {
            if(res.status === 200) {
                let f = []
                for (let i=0; i<res.data.length;i++) {
                    res.data[i]["key"]=i+1;
                    if (!f.includes(res.data[i].jobTitle)) {
                        f[f.length] = res.data[i].jobTitle;
                    }
                }
                let values = []
                for (let i = 0; i< f.length; i++) {
                    values[i] = {text: f[i], value: f[i]};
                }
                setFilters(values);
                setData(res.data);
            } else {
                setError(true);   
            }
            setLoading(false);
        }).catch((err) => {
            setError(true)
        });
    }, []);

    if (!!inError) {
        return <div style={{color: "red", fontFamily: "Arial"}}>There was a error in communicating with the server</div>
    } else if (!!data) {
        const columns = [{
            title: "Name", 
            dataIndex: "name", 
            key: "name",
            sortDirecttions: ["descend", "ascend"],
            sorter: (a, b) => a.name.localeCompare(b.name),
            render: text => <div >{text}</div>
        },
        {
            title: "Surname", 
            dataIndex: "surname", 
            key: "surname",
            sortDirecttions: ["descend", "ascend"],
            sorter: (a, b) => a.surname.localeCompare(b.surname),
            render: text => <div >{text}</div>
        },
        {
            title: "Job Title", 
            dataIndex: "jobTitle", 
            key: "jobTitle",
            filters: filters,
            filterMultiple: false,
            onFilter: (value, record) => record.jobTitle === value,
            sorter: (a, b) => a.jobTitle.localeCompare(b.jobTitle),
            sortDirecttions: ["descend", "ascend"],
            render: text => <div >{text}</div>
        },
        {
            title: "Age", 
            dataIndex: "age", 
            key: "age",
            defaultSortOrder: "descend",
            sortDirecttions: ["descend", "ascend"],
            sorter: (a, b) => a.age - b.age,
            render: text => <div >{text}</div>
        }];
        return <div><Table 
                        loading={isLoading} 
                        dataSource={data} 
                        columns={columns}
                        title={() => "BMW Assessment data display with ant design"}/>
                </div>
    } else {
        return <div style={{color: "black", fontFamily: "Arial"}}>No results found</div>
    }

}